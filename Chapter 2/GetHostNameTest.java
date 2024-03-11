package chapter2;

import java.net.InetAddress; 
public class GetHostNameTest {
	
	public static void main(String[] args){
	try{
	InetAddress address=InetAddress.getByName("www.google.com");
	

	System.out.println("Host Name: "+address.getHostName());
	

	}catch(Exception e){System.out.println(e);}
	}
	}
