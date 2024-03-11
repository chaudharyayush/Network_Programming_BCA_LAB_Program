package basicClientServer;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket ss = new Socket("localhost", 13001);
        System.out.println("connected...");
        
        // read something to send to the server
        // InputStreamReader read = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(System.in);
        // BufferedReader stdin = new BufferedReader(read);
        System.out.println("Write message to server: ");
        // int msgForServer = myObj.nextInt();
        String msgForServer = scanner.nextLine();
        // String msgForServer = stdin.readLine();

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
