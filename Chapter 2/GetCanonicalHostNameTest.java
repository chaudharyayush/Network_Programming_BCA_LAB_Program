package chapter2;

import java.net.*;

public class GetCanonicalHostNameTest {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			System.out.println(address);
			System.out.println("Canonical Host Name: " + address.getCanonicalHostName());

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
