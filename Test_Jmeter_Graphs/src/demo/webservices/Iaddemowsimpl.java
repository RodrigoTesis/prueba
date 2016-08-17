package demo.webservices;

import java.rmi.RemoteException;

public class Iaddemowsimpl implements Iaddemows{

	@Override
	public String getSaludoImagineando(String nombre) throws RemoteException {
		
		return "Hola mi nombre es "+nombre;
	}
}
