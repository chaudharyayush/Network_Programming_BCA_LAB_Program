package rmiSumImplementationExample;


import java.rmi.*;
import java.io.*;
import java.util.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class SumClient {
    public static void main(String[] args) {
        try {
            // Get a reference to the RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1999);

            // Look up the remote object from the registry
            SumInterface robj = (SumInterface) registry.lookup("Sum Service");

            // Invoke the sum method on the remote object
            int result = robj.sum(5, 3);

            System.out.println("Sum: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
