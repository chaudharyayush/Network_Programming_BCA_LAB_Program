package rmiSumImplementationExample;

import java.rmi.*;

public interface SumInterface extends Remote 
{
  public int sum(int a, int b) throws RemoteException;
}