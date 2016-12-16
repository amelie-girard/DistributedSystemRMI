package server;


import java.net.InetAddress;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;





public class LocateGlobalRegistry {
	
	// default listening port for the registry
		  private static final int REGISTRY_PORT = 1099;
		  private static final String SERVICE_NAME = "GlobalRegistry";

	public static Registry createRegistry() throws RemoteException{
		
		Registry reg = LocateRegistry.createRegistry(REGISTRY_PORT);
		
		GlobalRegistry globalReg = new GlobalRegistry();
		
		Remote stub = UnicastRemoteObject.exportObject(globalReg, 0);
	    System.out.println("server: generated skeleton and stub");

	    // register the remote object's stub in the registry
	    reg.rebind(SERVICE_NAME, stub);
		
		return reg;
	}
	
	public static Registry getRegistry() throws AccessException, RemoteException, NotBoundException{
		
		return LocateGlobalRegistry.getRegistry("localhost");
	}
	
	public static Registry getRegistry(String host) throws AccessException, RemoteException, NotBoundException{
		
		return (Registry) LocateRegistry.getRegistry(host).lookup(SERVICE_NAME);
	}
	
}
