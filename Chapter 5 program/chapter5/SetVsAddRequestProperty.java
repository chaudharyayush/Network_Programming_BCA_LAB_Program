package chapter5;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class SetVsAddRequestProperty {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.example.com");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// setRequestProperty
			//explain- The setRequestProperty() method sets the HTTP request header specified by "User-Agent" to "Mozilla/5.0". However, since setRequestProperty() overwrites any existing header value for the same key, the second call replaces "Mozilla/5.0" with "Chrome/90.0"
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			connection.setRequestProperty("User-Agent", "Chrome/90.0");

			// addRequestProperty
			//explain- The addRequestProperty() method adds a new header value to the existing headers without removing any previous values for the same key. In this case, "Accept-Language" initially has "en-US" added, followed by "NE"
			connection.addRequestProperty("Accept-Language", "en-US");
			connection.addRequestProperty("Accept-Language", "NE");

			Map<String, List<String>> requestProperties = connection.getRequestProperties();

			for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
				String headerName = entry.getKey();
				List<String> headerValues = entry.getValue();

				System.out.println(headerName + ": " + String.join(", ", headerValues));
			}

			connection.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}