//Print the last modified date of a given URL
package chapter5;

import java.io.*;
import java.net.*;
import java.util.*;

public class HeaderLastModify {
	public static void main(String[] args) {
		String url= "http://www.ibiblio.org/xml/";
			try {
				URL u = new URL(url);
				HttpURLConnection http = (HttpURLConnection) u.openConnection();
				http.setRequestMethod("HEAD");
				System.out.println(u + " was last modified at " + new Date(http.getLastModified()));
			} catch (MalformedURLException ex) {
				System.err.println(url + " is not a URL I understand");
			} catch (IOException ex) {
				System.err.println(ex);
			}
			System.out.println();
		}
	
}
