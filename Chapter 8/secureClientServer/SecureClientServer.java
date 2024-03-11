package secureClientServer;

import java.io.*;
import javax.net.ssl.*;

public class SecureClientServer {
    public static void main(String[] args) {
        int port = 443; // default https port
        String host = "merojob.com";
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = null;
        try {
            socket = (SSLSocket) factory.createSocket(host, port);
            
            // tells you which combination of algorithms is available on a given socket
            String[] supported = socket.getSupportedCipherSuites();
            
            // enable all the suites
            socket.setEnabledCipherSuites(supported);
            Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            
            // https requires the full URL in the GET line
            out.write("GET http://" + host + "/ HTTP/1.1\r\n");
            out.write("Host: " + host + "\r\n");
            out.write("\r\n");
            out.flush();
            
            // read response
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            
            // read the header
            String s;
            while (!(s = in.readLine()).equals("")) {
                System.out.println(s);
            }
            
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
            }
        }
    }
}
