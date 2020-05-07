package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private int nrPlayers=0;
    public ClientThread(Socket socket,int nrPlayers) {
        this.socket = socket;
        this.nrPlayers=nrPlayers;

    }

    public void run() {
        try {
            while(true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String request = in.readLine();
                String response = this.execute(request);
                out.println(response);
                out.flush();
                if(response.equals("Server stopped "))
                {
                   break;
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

            return "Game created";
        }
        else if(request.equals("join game"))
        {


            return "You start the game";
        }
        else if(request.equals("submit move")){
            return "Give position of the square from the board where you want to place your piece ( two numbers for x and y)";
        }
            return "Server received request " + request;
    }
}
