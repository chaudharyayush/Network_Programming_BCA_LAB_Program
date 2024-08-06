package basicRedirector;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	public static void main(String[] args) throws IOException {

		Socket ss = new Socket("localhost", 8000);
		System.out.println("connected...");

		// send message to server
		PrintWriter out = new PrintWriter(ss.getOutputStream(), true);

		out.println("GET /old-location HTTP/1.1"); //Sends an HTTP GET request to the server, requesting the resource at /old-location using HTTP/1.1.
		out.println("Host: example.com"); //Sends the Host header to the server. This is required by HTTP/1.1 to indicate the domain name of the server.

		// read response from the server
		InputStream in = ss.getInputStream();
		BufferedReader input = new BufferedReader(new InputStreamReader(in));
		String response;
		System.out.println("server: ");
		while ((response = input.readLine()) != null) {
			System.out.println(response);
		}

		ss.close();
	}
}
