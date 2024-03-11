import java.io.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
	public static void main(String[] argv) {
		try {
			 // Create an instance of the remote object
			Hello robj = new Hello("Hello, world!");

            // Start the RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry
            registry.rebind("Hello Service", robj);
			System.out.println("Hello Server is ready.");
		} catch (Exception e) {
			System.out.println("Hello Server failed: " + e);
		}
	}
}