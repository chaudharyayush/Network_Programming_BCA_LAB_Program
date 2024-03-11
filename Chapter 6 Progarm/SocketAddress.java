package chapter6;


import java.net.*;

public class SocketAddress {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("www.google.com", 80);
            System.out.println("Remote address: " + socket.getRemoteSocketAddress());
            System.out.println("Local address: " + socket.getLocalSocketAddress());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
