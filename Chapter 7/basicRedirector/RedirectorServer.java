package basicRedirector;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

public class RedirectorServer {
	//private: The variable is only accessible within the RedirectorServer class.
	//final: The value of the variable cannot be changed once it is initialized.
	//static: The variable is shared across all instances of the class.
    private final static int port = 8000;
    private final static String newSite = "http://example.com/new-resource-path"; // Full URL for redirection
    private static final Logger logger = Logger.getLogger("Redirector");

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            logger.info("Redirecting connections on port "
                    + server.getLocalPort() + " to " + newSite);
            while (true) { //Infinite loop to continuously accept incoming connections.
                Socket cs = server.accept();
                
                //Creates a PrintWriter to send output to the client. true enables auto-flush.
                PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
                
                //Reads the input from the client using a BufferedReader wrapped around an InputStreamReader
                String input = new BufferedReader(
                        new InputStreamReader(cs.getInputStream())).readLine();

                

                if (input != null && input.contains("HTTP")) {
                    out.write("HTTP/1.0 302 FOUND\r\n");
                    Date now = new Date();
                    out.write("Date: " + now + "\r\n");
                    out.write("Server: Redirector 1.1\r\n");
                    out.write("Location: " + newSite  + "\r\n");
                    out.write("Content-type: text/html\r\n\r\n");
                    out.flush();
                }
                // produce HTML that says where the document has moved to.
                out.write("<HTML><HEAD><TITLE>Document moved</TITLE></HEAD>\r\n");
                out.write("<BODY><H1>Document moved</H1>\r\n");
                out.write("The document " 
                        + " has moved to\r\n<A HREF=\"" + newSite  + "\" >"
                        + "</A>.\r\n Please update your bookmarks<P>");
                out.write("</BODY></HTML>\r\n");
                out.flush();

                try {
                    cs.close();
                } catch (Exception e) {
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
