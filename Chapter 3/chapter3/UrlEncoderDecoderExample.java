package chapter3;

import java.net.URLEncoder;
import java.net.URLDecoder;

public class UrlEncoderDecoderExample {
   public static void main(String[] args) {
      try {
         // URL to be encoded
         String url = "https://www.example.com/search?q=query string";

         // Encode the URL
         String encodedUrl = URLEncoder.encode(url, "UTF-8");

         // Print the encoded URL
         System.out.println(encodedUrl); // Output: https%3A%2F%2Fwww.example.com%2Fsearch%3Fq%3Dquery+string

         // Decode the URL
         String decodedUrl = URLDecoder.decode(encodedUrl, "UTF-8");

         // Print the decoded URL
         System.out.println(decodedUrl); // Output: https://www.example.com/search?q=query string

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

