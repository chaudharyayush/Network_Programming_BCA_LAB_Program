package chapter6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DayTimeClient {
    public static void main(String[] args) {
        final String hostname = "time.nist.gov";
        final int port = 13;
        Socket socket = null;

        try {
            socket = new Socket(hostname, port);

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "ASCII"));

            StringBuilder time = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                time.append(line).append("\n");
            }

            System.out.println(time.toString());

            reader.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
