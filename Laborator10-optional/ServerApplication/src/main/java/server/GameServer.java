package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean serverRunning=false;
    private Lock gameLock;
    public Condition waitOtherToConnect;
    public Condition waitOtherPlayerTurn;
    private Player[] listPlayers=new Player[2];

    public static void main(String[] args) throws IOException {
        GameServer gameServer=new GameServer();
        gameServer.startServer();
        gameServer.execute();
    }
    private void startServer() {
        try {
            serverSocket=new ServerSocket(PORT);
            this.serverRunning=true;
            System.out.println("Server start !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void execute() throws IOException {
        var pool=Executors.newFixedThreadPool(2);
        gameLock = new ReentrantLock();
        waitOtherToConnect=gameLock.newCondition();
        waitOtherPlayerTurn=gameLock.newCondition();
        Game game=new Game();
                game.setBoard(new Board());
        int nrPlayers=-1;
        try{
            while(serverRunning) {
                System.out.println("Waiting for client ");
                Socket socket = serverSocket.accept();
                nrPlayers++;
                listPlayers[0].setWaiting(false);
                game.setActivePlayer(0);
                listPlayers[nrPlayers] = new Player(socket, nrPlayers, game);
                pool.execute(listPlayers[nrPlayers]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stop() throws IOException {
        this.serverRunning=false;
        serverSocket.close();
    }
}
