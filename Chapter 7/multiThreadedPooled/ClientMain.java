package multiThreadedPooled;


import java.io.*;
import java.net.*;
import java.util.*;
 
public class ClientMain {
    public static void main(String[] args) throws IOException {
 
        Socket ss = new Socket("localhost", 7000);
        System.out.println("connected...");
        
        // read something to send to the server
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write message to server: ");
        String msgForServer = scanner.nextLine();
 
        // send message to server
        PrintWriter out = new PrintWriter(ss.getOutputStream(), true);
        out.println(msgForServer);
        System.out.println("you: " + msgForServer);
 
        // read response from the server
        InputStream in = ss.getInputStream();
        BufferedReader input = new BufferedReader(new InputStreamReader(in));
        String response = input.readLine();
        System.out.println("server: " + response);
 
        ss.close();
    }
}
 