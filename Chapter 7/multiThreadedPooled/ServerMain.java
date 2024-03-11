package multiThreadedPooled;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {
    private static final int PORT = 7000;
    static ExecutorService pool = Executors.newFixedThreadPool(50);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                
                ClientHandlerThread clientHandler = new ClientHandlerThread(socket);
                pool.submit(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
