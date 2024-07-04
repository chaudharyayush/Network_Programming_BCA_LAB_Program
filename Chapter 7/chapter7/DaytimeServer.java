package chapter7;

import java.net.*;
import java.io.*;
import java.util.Date;

public class DaytimeServer {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(13)) {
			System.out.println("Server Started");
			while (true) {
				try (Socket connection = server.accept()) {
					//Creates a Writer to send data to the client. It wraps the OutputStream obtained from the Socket object in an OutputStreamWriter to handle character encoding.
					//If you don't use OutputStreamWriter: You need to manually convert characters to bytes using an appropriate character encoding (e.g., UTF-8, ISO-8859-1).
					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					out.write(now.toString() + "\n");
					out.flush();
					connection.close();
				}
				catch (IOException ex) {
				}
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
