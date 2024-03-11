import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;

public class HelloClient {
	public static void main(String[] argv) {
		try {
			// Get a reference to the RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object from the registry
			HelloInterface hello = (HelloInterface) registry.lookup("Hello Service");
			System.out.println(hello.say());
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}
}