//Download a web page with a URLConnection
package chapter5;


import java.io.*;
import java.net.*;

public class URLWebPageDownload {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com");
        URLConnection connection = url.openConnection();
        InputStream raw = connection.getInputStream();
        InputStream buffer = new BufferedInputStream(raw);
        Reader reader = new InputStreamReader(buffer);
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        reader.close();
    }
}
