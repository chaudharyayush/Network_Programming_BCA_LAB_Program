package chapter5;




import java.io.*;
import java.net.*;

public class UrlConnectionTimeOut {
	public static void main(String[] args) {
		try {
			URL u = new URL("http://www.oreilly.com/jkjh");
			URLConnection uc = u.openConnection();
			//uc.setConnectTimeout(0);// A timeout value of 0 indicates an infinite timeout, meaning the connection will wait indefinitely for the connection to establish.
			uc.setConnectTimeout(200);//time in millisecond
			uc.connect();
			System.out.println("connected");
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
