package Chapter2;

import java.net.InetAddress;

public class TestRechability {
    
    public static void main(String[] args) {
        
        try {
            // Check if Google is reachable with a timeout of 5 seconds
            boolean isGoogleReachable = InetAddress.getByName("www.esewa.com").isReachable(5000);
            System.out.println("Is Google reachable? " + isGoogleReachable);
            
            // Check if localhost is reachable with a custom TTL and timeout
            boolean isLocalhostReachable = InetAddress.getByName("google.com").isReachable(null, 1, 10);
            System.out.println("Is localhost reachable? " + isLocalhostReachable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
