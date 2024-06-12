package dataRetrieve;

import java.io.*;
import java.net.*;

public class OpenStreamDemo {
	public static void main(String[] args) throws URISyntaxException {
		try {
			String urlString = "https://www.facebook.com/";
			// Create a URI object
			URI uri = new URI(urlString);
			// Convert URI to URL
			URL url = uri.toURL();
			// URL url = new URL("https://www.facebook.com/");
			InputStream stream = url.openStream();
			int i;
			System.out.println("running");
			while ((i = stream.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
