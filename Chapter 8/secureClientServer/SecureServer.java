package secureClientServer;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class SecureServer {
    public static void main(String[] args) {
        int port = 8888;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client connected");
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                out.println("Welcome to the SSL server");
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received from client: " + inputLine);
                    out.println("Server received: " + inputLine);
                }
                System.out.println("Client disconnected");
                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
