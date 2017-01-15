/**
 * @author Amélie GIRARD & Paul-Axel MARIE
 * @description Distributed System - Project RMI
 * @info EFREI - IL - P2017
 * @date 2016-12-20
 */

package pkg.server;

//import java.net.InetAddress;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * LocateGlobalRegistry
 * Define Static methods
 */
public class LocateGlobalRegistry {
	
	// Listening port for the registry
	private static final int REGISTRY_PORT = 1099;
	private static final String SERVICE_NAME = "GlobalRegistry";

	/**
	 * CreateRegistry()
	 * Used by the server Registry to initialize a registry
	 * 
	 * @return {Registry} - The created registry
	 * @throws RemoteException
	 */
	public static Registry createRegistry() throws RemoteException {
		
		Registry reg = LocateRegistry.createRegistry(REGISTRY_PORT);
		
		GlobalRegistry globalReg = new GlobalRegistry();
		
		// Skeleton and Stub Generation
		Remote stub = UnicastRemoteObject.exportObject(globalReg, 0);
	    System.out.println("LocateGlobalRegistry.createRegistry: Skeleton and Stub Generated");

	    // Register the remote object's stub in the registry
	    reg.rebind(SERVICE_NAME, stub);
		
		return reg;
	}
	
	/**
	 * getRegistry
	 * Used by the server Calculator to retrieve the local registry
	 * 
	 * @return {Registry}
	 * @throws AccessException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public static Registry getRegistry() throws AccessException, RemoteException, NotBoundException {
		
		return LocateGlobalRegistry.getRegistry("localhost");
	}
	
	/**
	 * getRegistry
	 * Used by the client to retrieve the stub from the registry of the corresponding SERVICE: GlobalRegistry
	 * 
	 * @param {Srtring} host
	 * @return {Registry}
	 * @throws AccessException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public static Registry getRegistry(String host) throws AccessException, RemoteException, NotBoundException{
		
		return (Registry) LocateRegistry.getRegistry(host).lookup(SERVICE_NAME);
	}
	
}
