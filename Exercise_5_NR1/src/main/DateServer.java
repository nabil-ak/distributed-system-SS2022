package main;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface DateServer extends Remote {
  public Date getDate () throws RemoteException;
}
