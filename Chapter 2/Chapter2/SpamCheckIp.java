package Chapter2;



import java.net.*;

public class SpamCheckIp {
	public static final String blackhole = "sbl.spamhaus.org";

	private static boolean isSpam(String addr) {

		try {

			String query = blackhole;
			InetAddress ia = InetAddress.getByName(addr);

			byte[] bytes = ia.getAddress();
			for (byte b : bytes) {
				// bytes are 8-bit signed numbers, so add 256 in case of -ve value
				// 256 - 8-bit max value
				int a = b < 0 ? b + 256 : b;
				query = a + "." + query;
				
			}
			
			InetAddress.getByName(query);

			return true;
		} catch (UnknownHostException e) {
			// false if not found on spanhaus server
			return false;
		}
	}

	public static void main(String[] args) {
		// spam IP list -> 	https://github.com/stamparm/ipsum	
		String[] arr = { "92.118.39.120", "167.94.146.53", "127.0.0.1", "8.8.8.8"};

		for (String arg : arr) {
			if (isSpam(arg)) {
				System.out.println(arg + " is Spammer");
			} else {
				System.out.println(arg + " seems Legit");
			}
		}

	}

}