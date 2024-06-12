package Chapter2;

import java.net.*;

public class GetCanonicalHostNameTest {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www.facebook.com");
			System.out.println(address);
			System.out.println("Canonical Host Name: " + address.getCanonicalHostName());

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
