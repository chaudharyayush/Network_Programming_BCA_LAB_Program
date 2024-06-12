package Chapter2;

import java.net.Inet4Address;  
import java.util.Arrays;  
import java.net.InetAddress;  
public class InetAddressMethod  
{  
public static void main(String[] arg) throws Exception  
{  
InetAddress ip =  Inet4Address.getByName("127.0.0.1");  
//InetAddress ip1 =  Inet4Address.getLocalHost();  
//System.out.println(ip1);
//InetAddress ip2 = InetAddress.getByName("localhost");
//System.out.println(ip2);


System.out.print("\nAddress : " +Arrays.toString(ip.getAddress()));  
System.out.print("\nHost Address : " +ip.getHostAddress());  
System.out.print("\nisAnyLocalAddress : " +ip.isAnyLocalAddress());  
System.out.print("\nisLinkLocalAddress : " +ip.isLinkLocalAddress());  
System.out.print("\nisLoopbackAddress : " +ip.isLoopbackAddress());  
System.out.print("\nisMCGlobal : " +ip.isMCGlobal());  
System.out.print("\nisMCLinkLocal : " +ip.isMCLinkLocal());  
System.out.print("\nisMCNodeLocal : " +ip.isMCNodeLocal());  
System.out.print("\nisMCOrgLocal : " +ip.isMCOrgLocal());  
System.out.print("\nisMCSiteLocal : " +ip.isMCSiteLocal());  
System.out.print("\nisMulticastAddress : " +ip.isMulticastAddress());  
System.out.print("\nisSiteLocalAddress : " +ip.isSiteLocalAddress());  
  
}  
}  
