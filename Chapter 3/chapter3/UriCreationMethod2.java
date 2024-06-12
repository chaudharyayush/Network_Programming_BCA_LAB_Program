package chapter3;

import java.net.URI;
import java.net.URISyntaxException;

public class UriCreationMethod2 {
    public static void main(String[] args) {
        try {
            // create a URI object with a scheme, ssp(Scheme-Specific Part), and fragment
            URI uri = new URI("https", "//example.com/path?query=value", "fragment");

            // print out the URI components
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("SSP: " + uri.getSchemeSpecificPart());
            System.out.println("Fragment: " + uri.getFragment());
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        }
    }
}

