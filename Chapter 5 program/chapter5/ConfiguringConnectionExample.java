	package chapter5;

import java.io.IOException;
import java.net.URLConnection;
import java.net.URL;

public class ConfiguringConnectionExample {
	public static void main(String[] args) {
		try {
			// Create a URL object
			URL url = new URL("http://www.example.com");

			// Open a connection to the URL
			URLConnection connection = url.openConnection();

			System.out.println("URL: " + connection.getURL());
			System.out.println("Allow User Interaction: " + connection.getAllowUserInteraction());
			System.out.println("Do Output: " + connection.getDoOutput());
			System.out.println("Use Cache: " + connection.getUseCaches());

			// Configure the URLConnection
			connection.setAllowUserInteraction(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);

			// Get and print the configuration of the URLConnection
			System.out.println("Allow User Interaction: " + connection.getAllowUserInteraction());
			System.out.println("Do Output: " + connection.getDoOutput());
			System.out.println("Use Cache: " + connection.getUseCaches());

			connection.connect();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}