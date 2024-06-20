package chapter5;

import java.io.*;
import java.net.*;

public class GuessContentTypeExample {
	public static void main(String[] args) {
		// Example filenames
		String filename1 = "example.html";
		String filename2 = "example.png";

		// Guess MIME types
		String mimeType1 = URLConnection.guessContentTypeFromName(filename1);
		String mimeType2 = URLConnection.guessContentTypeFromName(filename2);

		// Print results
		System.out.println(filename1 + " MIME type: " + mimeType1); // Should print "text/html"
		System.out.println(filename2 + " MIME type: " + mimeType2); // Should print "image/png"
	}
}
