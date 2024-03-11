package chapter3;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseRelativeResolvedUrlTest {

    public static void main(String[] args) {
        try {
            // Define a base URL
            URL baseURL = new URL("https://www.example.com/");

            // Define a relative URL
            String relativeURL = "foo/bar.html";

            // Resolve the relative URL against the base URL to get the absolute URL
            URL resolvedURL = new URL(baseURL,relativeURL);

            // Print the results
            System.out.println("Base URL: " + baseURL);
            System.out.println("Relative URL: " + relativeURL);
            System.out.println("Resolved URL: " + resolvedURL);

        } catch (MalformedURLException  e) {
			System.out.println(e.getMessage());
        }
    }
}

