package Chapter2;

import java.io.*;
import java.net.*;

public class Inet4AddressExample {
	public static void main(String[] args) {
		try {
			//Get the Inet4Address object for a given IP address string
			
			Inet4Address ip = (Inet4Address) Inet4Address.getByName("8.8.8.8");

			System.out.println("Host Name: " + ip.getHostName());
			System.out.println("IP Address: " + ip.getHostAddress());

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
