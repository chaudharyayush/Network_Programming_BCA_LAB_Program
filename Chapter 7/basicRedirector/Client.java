package basicRedirector;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket ss = new Socket("localhost", 8000);
        System.out.println("connected...");

        // send message to server
        PrintWriter out = new PrintWriter(ss.getOutputStream(), true);
        
        out.println("GET /old-location HTTP/1.1");
        out.println("Host: example.com");

        // read response from the server
        InputStream in = ss.getInputStream();
        BufferedReader input = new BufferedReader(new InputStreamReader(in));
        String response;
        System.out.println("server: ");
        while((response = input.readLine()) != null){
            System.out.println(response);
        }

        ss.close();
    }
}
