package dataRetrieve;

import java.io.*;
import java.net.*;

public class OpenConnectionDemo {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://dummyjson.com/recipes/1");
			URLConnection urlcon = url.openConnection();
			InputStream stream = urlcon.getInputStream();
			int i;
			while ((i = stream.read()) != -1) {
				System.out.print((char) i);
			}
			System.out.println("\nURL Header => Content Type: " + urlcon.getContentType());
			System.out.println("URL Header => Content Length : " + urlcon.getContentLength());
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}