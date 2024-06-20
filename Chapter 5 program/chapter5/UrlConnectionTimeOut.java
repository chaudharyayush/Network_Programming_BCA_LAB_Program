package chapter5;




import java.io.*;
import java.net.*;

public class UrlConnectionTimeOut {
	public static void main(String[] args) {
		try {
			URL u = new URL("http://www.oreilly.com/jkjh");
			URLConnection uc = u.openConnection();
			uc.setConnectTimeout(0);
			uc.connect();
			System.out.println("connected");
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
