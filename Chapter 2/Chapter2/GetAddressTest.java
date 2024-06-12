package Chapter2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class GetAddressTest {
	public static int getVersion(InetAddress ia) {
		byte[] address = ia.getAddress();
		if (address.length == 4)
			return 4;
		else if (address.length == 16)
			return 6;
		else
			return -1;
	}

	public static void main(String[] args) throws UnknownHostException {
		InetAddress local = InetAddress.getByName("127.0.0.1");
		System.out.print("Address : " +Arrays.toString(local.getAddress()));
		int version = getVersion(local);
		System.out.println("\n"+version);
	}
}
