package socketConstructorMethod;
//3. public Socket(String host, int port, InetAddress localAddress, int localPort) throws IOException.
import java.net.*;
import java.io.*;

public class Method2 {
    public static void main(String[] args) {
        String remoteHost = "example.com";
        int remotePort = 80; // HTTP port
        
        try {
            // Specify local address and port
            InetAddress localAddress = InetAddress.getLocalHost(); // Local machine's address
            int localPort = 54321; // Arbitrary local port
            
            // Create a socket and connect to the remote server while binding to local address and port
            Socket socket = new Socket(remoteHost, remotePort, localAddress, localPort);
            
            // Now you can use the socket for communication
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("GET / HTTP/1.1");
            writer.println("Host: " + remoteHost);
            writer.println();
            writer.flush();
            
            // Read response from the server
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Close the socket when done
            socket.close();
            
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + remoteHost);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}

