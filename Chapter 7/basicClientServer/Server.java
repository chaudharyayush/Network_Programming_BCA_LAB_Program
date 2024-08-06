package basicClientServer;
import java.io.*;
import java.net.*;

public class Server{
	
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(13001);
       
        
        System.out.println("Waiting for connections....");
        Socket cs = ss.accept();
        System.out.println("connected...");

        // read the message
        InputStreamReader in = new InputStreamReader(cs.getInputStream());
        BufferedReader input = new BufferedReader(in);
        String message = input.readLine();
        System.out.println("client: " + message);

        // send response
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        out.println("you said, "+ "'"+message+"'");

        ss.close();
    }
}
