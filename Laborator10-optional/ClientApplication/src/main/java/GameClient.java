import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    private final static String serverAddress = "127.0.0.1";
    private final static int PORT = 8100;

    public static void main(String[] args) {
        GameClient gameClient = new GameClient();
        System.out.println("Choose one of the command:create game,join game,submit move");
        while (true) {
            String request = gameClient.readCommandsKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else {
                gameClient.sendRequest(request);
            }
        }
    }

    private void sendRequest(String request) {
        try {
            Socket socket = new Socket(serverAddress, PORT);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter((socket.getOutputStream()));
            printWriter.println(request);
            printWriter.flush();
            String response = bufferedReader.readLine();
            System.out.println(response);
        } catch (UnknownHostException e) {
            System.err.println("Not find server listening " + e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private String readCommandsKeyboard() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        System.out.println("[Client]Read from Keyboard command : " + command);
        return command;
    }
}
