package chapter5;


import java.io.*;
import java.net.*;

public class ConfiguringConnectionExample {
    public static void main(String[] args) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL("http://www.example.com");
            connection = (HttpURLConnection) url.openConnection();

            // Configure the connection
            connection.setDoInput(true); // Allow input (reading from the resource)
            connection.setDoOutput(false); // No output (not sending data)
            connection.setUseCaches(true); // Use caches if available
            connection.setAllowUserInteraction(false); // Disable user interaction
            connection.setIfModifiedSince(0); // Set to 0 to ensure the latest version is fetched

            // Establish the connection
            connection.connect();

            // Use the connection to read data (input stream)
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect(); // Disconnect the connection
            }
        }
    }
}
