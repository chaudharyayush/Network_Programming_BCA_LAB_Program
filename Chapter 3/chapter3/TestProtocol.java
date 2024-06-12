package chapter3;

import java.net.*;

public class TestProtocol {
    public static void main(String[] args) {
        testProtocol("ftp://192.168.99.2");
        testProtocol("http://google.com");
        testProtocol("jdbc:mysql://luna.metalab.unc.edu:3306/NEWS");  // not supported by URL constructor
    }


    private static void testProtocol(String url){
        try{
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is suported.");
        }catch(Exception ex) {
            String protocol = url.substring(0, url.indexOf(":"));
            System.out.println(protocol + " is not supported");
        }
    }
}