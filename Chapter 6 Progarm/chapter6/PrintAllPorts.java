package chapter6;

import java.net.*;
import java.io.*;

public class PrintAllPorts {
    public static void main(String [] args){
        for (int i =50700; i<=50774; i++){
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
