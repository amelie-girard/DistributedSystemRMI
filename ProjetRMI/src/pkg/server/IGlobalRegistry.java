/**
 * @author Amélie GIRARD & Paul-Axel MARIE
 * @description Distributed System - Project RMI
 * @info EFREI - IL - P2017
 * @date 2016-12-20
 */

package pkg.server;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.List;

/**
 * Interface for GlobalRegistry
 */
public interface IGlobalRegistry extends Registry {
	
	@Override
	public Remote lookup(String name) throws RemoteException, NotBoundException, AccessException;
	
	@Override
	public void bind(String name, Remote obj) throws RemoteException, AlreadyBoundException, AccessException;
	
	@Override
	public void rebind(String name, Remote obj) throws RemoteException, AccessException;
	
	@Override
	public void unbind(String name) throws RemoteException, NotBoundException, AccessException;
	
	@Override
	public String[] list() throws RemoteException, AccessException;
	
	// Return the stub list corresponding to one Service
	public List<Remote> list(String service) throws RemoteException, AccessException;
	
}
