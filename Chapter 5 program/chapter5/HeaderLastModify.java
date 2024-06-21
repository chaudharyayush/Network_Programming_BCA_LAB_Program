//Print the last modified date of a given URL
package chapter5;

import java.io.*;
import java.net.*;
import java.util.*;

public class HeaderLastModify {
	public static void main(String[] args) {
		// The URL to check for the last modified date
		String url = "http://www.ibiblio.org/xml/";

		try {
			// Create a URL object from the given string
			URL u = new URL(url);

			// Open a connection to the URL and cast it to HttpURLConnection
			HttpURLConnection http = (HttpURLConnection) u.openConnection();

			// Set the request method to HEAD to fetch only the headers
			http.setRequestMethod("HEAD");

			// Get the last modified date in milliseconds since epoch
			long lastModified = http.getLastModified();
			//System.out.println(lastModified);

			// Check if the last modified date is valid
			if (lastModified == 0) {
				System.out.println("No last-modified information.");
			} else {
				// Print the last modified date as a Date object
				System.out.println(u + " was last modified at " + new Date(lastModified));
			}
		} catch (MalformedURLException ex) {
			System.err.println(url + " is not a URL I understand");
		} catch (IOException ex) {
			System.err.println(ex);
		}
		System.out.println();
	}
}
