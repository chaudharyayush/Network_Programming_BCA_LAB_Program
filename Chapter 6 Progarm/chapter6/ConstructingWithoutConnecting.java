package chapter6;

import java.net.*;
import java.io.*;

public class ConstructingWithoutConnecting {
    public static void main(String [] args) {
        try {
            Socket socket = new Socket();
            InetSocketAddress address = new InetSocketAddress("time.nist.gov", 13);
            socket.connect(address);
            InputStream in = socket.getInputStream();
            InputStreamReader inr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inr);
            String line;
            while((line = br.readLine()) != null){

                System.out.println(line);
            }
            socket.close();
           } catch (IOException ex) {
            System.err.println(ex);
           }
    }
}
