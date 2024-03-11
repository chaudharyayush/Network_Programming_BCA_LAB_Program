package chapter3;
import java.net.*;

public class URLDemo {
	public static void main(String[] args) {
		try 
		{	
			URL url1= new URL("http://facebook.com/profile");
			System.out.println(url1.getProtocol());

			URL url2= new URL("ftp","facebook.com", "/profile");
			System.out.println(url2.getProtocol());

			URL url3= new URL("https","facebook.com",8000,"/profile");
			System.out.println(url3);
			System.out.println(url3.getProtocol());
			
			URL url4= new URL("http","facebook.com",8000,"/profile");
			URL url5= new URL(url4, "/login");
			System.out.println(url5);
			System.out.println(url5.getPath());

		}
		catch(MalformedURLException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}