package basicClientServer;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket ss = new Socket("localhost", 13001);
        System.out.println("connected...");
        
        // read something to send to the server
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write message to server: ");
        String msgForServer = scanner.nextLine();

        // send message to server
        PrintWriter out = new PrintWriter(ss.getOutputStream(), true); //true (autoFlush parameter)
        //ss.getOutputStream(): This method returns an OutputStream that is connected to the output side of the socket. It allows you to send raw bytes to the client.
        //new PrintWriter(ss.getOutputStream(), true): This constructs a PrintWriter object that wraps the OutputStream. The PrintWriter converts characters into bytes using a specified character encoding and writes them to the output stream.
        out.println(msgForServer);
        //out is PrintWriter object
        //println is method of the PrintWriter class
        //The println method writes the specified string followed by a newline character (\n). It’s similar to the print method but automatically appends a newline at the end
        System.out.println("you: " + msgForServer);

        // read response from the server
        BufferedReader input = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        String response = input.readLine();
        System.out.println("server: " + response);

        ss.close();
    }
}
