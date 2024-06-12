package chapter3;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;

public class AuthnticatorClass extends Authenticator {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        // Prompt the user for a username and password
        String username = "03268048";
        String password = "wefef";
        // Return the authentication credentials
        return new PasswordAuthentication(username, password.toCharArray());
    }

    public static void main(String[] args) {
        // Set the default authenticator to your custom authenticator
        Authenticator.setDefault(new AuthnticatorClass());

        try {
            // Create a URL object
            URL url = new URL("https://web.facebook.com/#/login");

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
