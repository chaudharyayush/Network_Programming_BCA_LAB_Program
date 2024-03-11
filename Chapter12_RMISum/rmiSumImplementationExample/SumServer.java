package rmiSumImplementationExample;



import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class SumServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            Sum robj = new Sum();

            // Start the RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1999);

            // Bind the remote object to the registry
            registry.rebind("Sum Service", robj);

            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
