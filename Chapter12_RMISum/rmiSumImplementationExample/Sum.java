package rmiSumImplementationExample;

//This is IMPLEMENTER class

import java.rmi.*;
import java.rmi.server.*;

public class Sum extends UnicastRemoteObject implements SumInterface {

	protected Sum() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int sum(int a, int b) throws RemoteException {
		return a + b;
	}
}