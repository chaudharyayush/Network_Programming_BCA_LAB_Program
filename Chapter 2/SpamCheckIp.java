package chapter2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamCheckIp {

    public static boolean isSpam(String ipAddress) {
        // Reverse the IP address and append the blacklist domain
        String blacklistDomain = "sbl.spamhaus.org";
        String reversedIpAddress = new StringBuilder(ipAddress).reverse().toString();
        String query = reversedIpAddress + "." + blacklistDomain;

        try {
            // Perform a DNS lookup on the query string
            InetAddress address = InetAddress.getByName(query);
            
            // Return true if the IP address is listed in the blacklist
            return address.getHostAddress().equals("127.0.0.2");
        } catch (UnknownHostException ex) {
            // The DNS lookup failed, so assume the IP address is not listed
            return false;
        }
    }

    public static void main(String[] args) {
        String ipAddress = "192.0.2.1";
        boolean isSpam = isSpam(ipAddress);
        System.out.println("Is Spam? \n"+isSpam);
    }
}
