package demo.webservices;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Iaddemows extends Remote{
	
	public String getSaludoImagineando(String nombre) throws RemoteException;

}
