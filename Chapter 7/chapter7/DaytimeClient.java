package chapter7;

import java.net.*;
import java.io.*;

public class DaytimeClient {

	public static void main(String[] args) {
		String serverAddress = "localhost"; // Change this to the server's address if it's not running locally
		int port = 13;

		try (Socket socket = new Socket(serverAddress, port)) {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//socket.getInputStream() returns an InputStream to read bytes directly from the socket.
			//new InputStreamReader(socket.getInputStream()) takes the raw byte stream and converts it into a character stream. This handles the character encoding and decoding.
			//new BufferedReader(new InputStreamReader(socket.getInputStream())) wraps the character stream in a BufferedReader to buffer the input. This allows for more efficient reading of characters and provides convenient methods like readLine().
			String serverResponse = in.readLine();
			//in.readLine(): This method reads a line of text from the BufferedReader input stream.
			//It reads characters from the input stream until it encounters a line terminator (\n, \r, or \r\n) or the end of the stream. 
			System.out.println("Server Date and Time: " + serverResponse);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
