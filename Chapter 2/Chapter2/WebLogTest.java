package Chapter2;

import java.io.*;
import java.net.*;

public class WebLogTest {

	public static void main(String[] args) {

		// Example file path (adjust if necessary)
		String file = "H:\\Teaching\\BCA NOTE\\NP\\My Note\\Note_For_Student\\Network_Programming_LAB_Program\\Chapter 2\\Chapter2\\logfile.txt";

		// Print the current working directory (for debugging)
		// System.out.println("Current working directory: " +
		// System.getProperty("user.dir"));

		try (FileInputStream fin = new FileInputStream(file);
				Reader in = new InputStreamReader(fin);
				BufferedReader bin = new BufferedReader(in)) {

			for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
				// Separate out the IP address
				int index = entry.indexOf(' '); // position of the first space
				if (index == -1) {
					System.out.println("Invalid log entry: " + entry);
					continue;
				}
				String ip = entry.substring(0, index); // Read IP
				String theRest = entry.substring(index); // Reads remaining (extra information)

				// Print diagnostic information
				System.out.println("Processing IP: " + ip);

				// Ask DNS for the hostname and print it out
				try {
					InetAddress address = InetAddress.getByName(ip);
					//System.out.println("Resolved hostname: " + address.getHostName());
					System.out.println(address.getHostName() + theRest);
				} catch (UnknownHostException ex) {
					System.out.println("Could not resolve hostname for IP: " + ip);
					System.out.println(entry);
				}
			}
		} catch (IOException ex) {
			System.out.println("Exception: " + ex);
		}
	}
}
