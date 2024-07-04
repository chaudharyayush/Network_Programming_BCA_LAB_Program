// Check if there is any port within 1000 associated with the localhost
package chapter6;

import java.net.*;
import java.io.*;

public class CheckHostPort {
	protected static String localhost = "127.0.0.1";

	public static void main(String[] args) {
		for (int i = 50000; i <= 50500; i++) {
			try {
				Socket s = new Socket(localhost, i);
				System.out.println("Port " + i + " is associated with " + localhost);
				s.close();
			} catch (IOException e) {
				System.out.println("Port " + i + " is not associated with " + localhost);
			}
		}
	}

}
