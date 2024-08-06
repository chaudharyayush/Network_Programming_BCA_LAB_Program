package secureClientServer;

import java.io.*;
import javax.net.ssl.*; //Imports classes for SSL/TLS network communications.

public class SecureClientServer {
    public static void main(String[] args) {
        int port = 443; // default https port
        String host = "merojob.com";
        
        //Create SSLSocketFactory: Gets the default SSLSocketFactory instance for creating SSL sockets.
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        
        //Declares a variable for the SSL socket, initially set to null.
        SSLSocket socket = null;
        try {
        	// Uses the factory to create an SSLSocket connected to the specified host and port.
            socket = (SSLSocket) factory.createSocket(host, port);
            
            // Retrieves the list of supported cipher suites for the SSL socket. 
            //Cipher suites are algorithms used for encrypting and securing data.
            String[] supported = socket.getSupportedCipherSuites();
            
            // enable all the suites
            socket.setEnabledCipherSuites(supported);
            
            //Creates a Writer to send data to the server using UTF-8 encoding.
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
