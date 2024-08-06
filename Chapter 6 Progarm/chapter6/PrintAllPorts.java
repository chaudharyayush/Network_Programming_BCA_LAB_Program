package chapter6;

import java.net.*;
import java.io.*;

public class PrintAllPorts {
    public static void main(String [] args){
    	//use this command to know the active connection netstat -a -n -o
        for (int i =0; i<=655; i++){
            try {
                ServerSocket s = new ServerSocket(i);
                System.out.println("Port "+i+" is available.");
                s.close();
            } catch (IOException e) {
                // TODO: handle exception
                System.out.println("port "+i+ " is already in use");
            }
        }
    }
}
