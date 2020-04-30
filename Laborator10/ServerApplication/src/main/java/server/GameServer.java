package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean serverRunning=false;

    public static void main(String[] args) throws IOException {
        GameServer gameServer=new GameServer();
        gameServer.startServer();
        gameServer.execute();
    }
    private void startServer() {
        try {
            serverSocket=new ServerSocket(PORT);
            this.serverRunning=true;
            System.out.println("Server start ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void execute() throws IOException {
        try{
            while(serverRunning){
                System.out.println("Waiting for client ");
                Socket socket=serverSocket.accept();
                new ClientThread(socket,this).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            serverSocket.close();
        }
    }
    public void stop() throws IOException {
        this.serverRunning=false;
        serverSocket.close();
    }
}
