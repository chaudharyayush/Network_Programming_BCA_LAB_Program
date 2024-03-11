package multiThreadedPooled;

import java.net.Socket;
import java.io.*;

public class ClientHandlerThread extends Thread{
    private final Socket connection;
    public ClientHandlerThread(Socket socket) {
        this.connection = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             PrintWriter writer = new PrintWriter(connection.getOutputStream(), true)) {

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received message: " + message);
                writer.println("You said: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
