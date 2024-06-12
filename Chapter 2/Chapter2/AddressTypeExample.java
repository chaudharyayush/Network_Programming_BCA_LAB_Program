package Chapter2;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressTypeExample {
    public static void main(String[] args) {
        try {
            // Example addresses
            InetAddress wildcardAddress = InetAddress.getByName("0.0.0.0");
            InetAddress loopbackAddress = InetAddress.getByName("127.0.0.1");
            InetAddress linkLocalAddress = InetAddress.getByName("FE80::1");
            InetAddress siteLocalAddress = InetAddress.getByName("FEC0::1");
            InetAddress multicastAddress = InetAddress.getByName("224.0.0.1");

            // Check and print the address types
            System.out.println("Wildcard Address: " + wildcardAddress.isAnyLocalAddress());
            System.out.println("Loopback Address: " + loopbackAddress.isLoopbackAddress());
            System.out.println("Link-Local Address: " + linkLocalAddress.isLinkLocalAddress());
            System.out.println("Site-Local Address: " + siteLocalAddress.isSiteLocalAddress());
            System.out.println("Multicast Address: " + multicastAddress.isMulticastAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
