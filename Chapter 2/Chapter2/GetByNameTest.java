package Chapter2;

import java.net.InetAddress; 
public class GetByNameTest {
	
	public static void main(String[] args){
	try{
	InetAddress address=InetAddress.getByName("www.esewa.com");
	 System.out.println(address);

	}catch(Exception e){System.out.println(e);}
	}
	}