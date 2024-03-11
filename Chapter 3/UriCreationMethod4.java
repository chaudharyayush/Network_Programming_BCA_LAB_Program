package chapter3;


import java.net.URI;
import java.net.URISyntaxException;

public class UriCreationMethod4 {
    public static void main(String[] args) {
        try {
            // create a URI object with scheme, host, path, and fragment
            URI uri = new URI("https", "example.com", "/path", "fragment");

            // print out the URI components
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Fragment: " + uri.getFragment());
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        }
    }
}
