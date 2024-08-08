package rmiSumImplementationExample;



import java.rmi.registry.Registry;//This imports the Registry interface from the java.rmi.registry package. The Registry interface is used to interact with the RMI registry, where remote objects are registered and looked up.
import java.rmi.registry.LocateRegistry;//The LocateRegistry class provides methods to create or locate the RMI registry.

public class SumServer {
    public static void main(String[] args) {
        try {
        	
        	//This line creates an instance of the Sum class, which is a remote object that implements the SumInterface. 
        	//This object will be registered with the RMI registry so that clients can invoke methods on it remotely.
            Sum robj = new Sum();

            // Start the RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1999);

            //This line binds the Sum object (robj) to the RMI registry under the name "Sum Service". 
            //The rebind method is used to either bind a new name or update an existing binding. 
            //This allows clients to look up the Sum object using the name "Sum Service".
            registry.rebind("Sum Service", robj);

            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
