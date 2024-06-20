package chapter5;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class SetHeaderExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");

            URLConnection connection = url.openConnection();

            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setRequestProperty("Custom-Header", "swastik");

            Map<String, List<String>> requestProperties = connection.getRequestProperties();
            
            for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue();
                
                System.out.println(headerName + ": " + String.join(", ", headerValues));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
