package Chapter2;

import java.net.InetAddress; 
public class GetHostAddressTest {
	
	public static void main(String[] args){
	try{
	InetAddress address=InetAddress.getByName("facebook.com");
	 

	System.out.println("IP Address: "+address.getHostAddress());
	

	}catch(Exception e){System.out.println(e);}
	}
	}

