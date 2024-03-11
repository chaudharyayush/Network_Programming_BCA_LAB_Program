package chapter3;

import java.io.*;
import java.net.*;

public class OpenStreamDemo {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.facebook.com/");
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
