// WAP to read from the server
package chapter6;

import java.io.*;
import java.net.*;

public class ReadFromServer {
    public static void main(String[] args) {
        try (Socket socket = new Socket("time.nist.gov", 13)) {
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();

            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(reader);
            
            
            String line;
            while((line=br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("something went wrong");
        }
    }
}