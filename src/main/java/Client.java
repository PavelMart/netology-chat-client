import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Client {
    private String ADDRESS;
    private int PORT;

    public Client(String settingsPath) {
        try (
                BufferedReader settingsReader = new BufferedReader(new FileReader(settingsPath))

        ) {
            ADDRESS = settingsReader.readLine();
            PORT = Integer.parseInt(settingsReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        try (
                Socket socket = new Socket(ADDRESS, PORT);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.println("Введите ваше имя:");
            String username = reader.readLine();

            startDialog(username, in, out);
            listenServer(in);
            sendMessage(username, reader, out);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String username, BufferedReader reader, PrintWriter out) throws IOException {
        String userInput;
        while ((userInput = reader.readLine()) != null) {
            if (userInput.equalsIgnoreCase("/exit")) {
                break;
            }
            out.println(userInput);
            Logger.log(username + ": " + userInput + "\n");
        }
    }

    private void startDialog(String username, BufferedReader in, PrintWriter out) throws IOException {
        out.println(username);

        String serverResponse = in.readLine();
        System.out.println(serverResponse);
    }

    private void listenServer(BufferedReader in) {
        new Thread(() -> {
            try {
                String serverMessage;
                while ((serverMessage = in.readLine()) != null) {
                    System.out.println("[" + new Date() + "] " + serverMessage);
                    Logger.log(serverMessage);
                }
            } catch (IOException e) {
                System.out.println("До свидания!");
            }
        }).start();
    }
}
