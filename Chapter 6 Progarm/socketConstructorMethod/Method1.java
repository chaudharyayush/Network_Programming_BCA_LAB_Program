package socketConstructorMethod;
//public Socket(InetAddress host, int port) throws IOException
import java.net.*;
import java.io.*;

public class Method1 {
    public static void main(String[] args) {
        String hostName = "example.com";
        int portNumber = 80; // HTTP port
        
        try {
            // Resolve the host name to get InetAddress
            InetAddress hostAddress = InetAddress.getByName(hostName);
            
            // Create a socket and connect to the server
            Socket socket = new Socket(hostAddress, portNumber);
            
            // Now you can use the socket for communication
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("GET / HTTP/1.1");
            writer.println("Host: " + hostName);
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
            System.err.println("Unknown host: " + hostName);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}

