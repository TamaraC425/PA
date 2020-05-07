package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread {
    private String name;
    private int id;
    private Game game;
    private Socket socket = null;
    private boolean waiting=true;

    public Player() {
    }

    public Player(Socket socket, int id,Game game) {
        this.socket = socket;
        this.id=id;
        this.game=game;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public String placeYourPiece(int x, int y)
    {
        Board board=game.getBoard();
        if(board.fullBoard()==true)
             game.finishGame();
        String message=board.addPieces(this,x,y);
        if(board.findWinner(x,y)==true)
        { game.finishGame();return "Game over ! Winner is "+this.getName();}
          return message;
    }
    public void run() {

        try {
            while(!game.isGameOver()) {
                if (!isWaiting() && game.getActivePlayer() == this.getId()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    String request = in.readLine();
                    String response = this.execute(request);
                    out.println(response);
                    out.flush();
                    if (this.getId() == 0) {
                        game.setActivePlayer(1);
                    } else if (this.getId() == 1) {
                        game.setActivePlayer(0);
                    }
                    setWaiting(true);
                    if (response.equals("Server stopped ")) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String execute(String request) throws IOException {
        System.out.println("Server received the request  : " + request);
        if (request.equals("stop")){
            return "Server stopped ";
        }
        else if(request.equals("create game"))
        {
            game.setBoard(new Board());
            return "Game created";
        }
        else if(request.equals("join game"))
        {

                return "You start the game";
        }
        else if(request.startsWith("submit move")){
            // "Give position of the square from the board where you want to place your piece ( two numbers for x and y)";
            int x,y;
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String response = "Give position x of the square from the board where you want to place your piece";
            out.println(response);
            out.flush();
            String inputX = in.readLine();
            x=Integer.parseInt(inputX);
            response = "Give position y of the square from the board where you want to place your piece";
            out.println(response);
            out.flush();
            String inputY= in.readLine();
            y=Integer.parseInt(inputY);
            String message=placeYourPiece(x,y);
            return message;
        }
        return "Server received request " + request;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", game=" + game +
                '}';
    }

}
