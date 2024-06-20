// Print the response code and message from a given url
package chapter5;

import java.io.*;
import java.net.*;

public class ResponseCodeMsg {
	public static void main(String[] args) {

		try {
			// Open the URLConnection for reading
			URL u = new URL("https://example.com");
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			int code = uc.getResponseCode();
			String response = uc.getResponseMessage();
			System.out.println("Code: " + code + "\n" + "Response Message: " + response);
		} catch (MalformedURLException ex) {
			System.err.println(" is not a parseable URL");
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
