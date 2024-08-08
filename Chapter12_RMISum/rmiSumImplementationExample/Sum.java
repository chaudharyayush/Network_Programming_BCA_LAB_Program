package rmiSumImplementationExample;

//This is IMPLEMENTER class

import java.rmi.*;
import java.rmi.server.*;

//extends UnicastRemoteObject: Sum extends UnicastRemoteObject, which is a class in the RMI library that provides the necessary functionality for remote objects. 
//This means that Sum is a remote object that can be exported for remote method calls.
//implements SumInterface: This specifies that Sum implements the SumInterface interface. This means that Sum must provide an implementation for all methods defined in SumInterface.

public class Sum extends UnicastRemoteObject implements SumInterface {

	//This is the constructor for the Sum class. It throws RemoteException because it is a remote object.
	protected Sum() throws RemoteException {
		super();// Calls the constructor of the superclass UnicastRemoteObject. This is necessary to properly initialize the remote object.
	}

	@Override //This annotation indicates that the method sum overrides a method declared in the SumInterface interface.
	public int sum(int a, int b) throws RemoteException {
		return a + b;
	}
}