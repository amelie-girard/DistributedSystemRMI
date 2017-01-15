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
//import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GlobalRegistry
 * Act like a proxy stub getter
 */
public class GlobalRegistry implements IGlobalRegistry {
	
	
	private Map <String, List<Remote>> keyRemoteList = new HashMap<>();
	private Map <String, Integer> keyRemoteList_it = new HashMap<>();

	/**
	 * Bind a remote object with a string id in the KeyRemoteList
	 * (Operated by the Server)
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 * @throws AccessException
	 */
	@Override
	public void bind(String name, Remote obj) throws RemoteException, AlreadyBoundException, AccessException {
		
		// TODO Auto-generated method stub
		List<Remote> list = keyRemoteList.get(name);
		
		if (list == null){
			list = new ArrayList<Remote>();
			keyRemoteList.put(name, list);
			keyRemoteList_it.put(name, 0);
		} 
		
		list.add(obj);
	}
	
	/**
	 * Re-bind a remote object with a string id in the KeyRemoteList
	 * (Operated by the Server)
	 * @throws RemoteException
	 * @throws AccessException
	 */
	@Override
	public void rebind(String name, Remote obj) throws RemoteException, AccessException {
		
		// TODO Auto-generated method stub
		List<Remote> list = keyRemoteList.get(name);
		
		if (list == null){
			list = new ArrayList<Remote>();
			keyRemoteList.put(name, list);
			keyRemoteList_it.put(name, 0);
		} 
		
		list.add(obj);
	}
	
	/**
	 * Un-bind the remote object of the specified remote name/string
	 * (Operated by the Server)
	 */
	@Override
	public void unbind(String name) throws RemoteException, NotBoundException, AccessException {
		// TODO Auto-generated method stub
	}

	/**
	 * Get the remote corresponding to the string name
	 * (Operated by the client)
	 */
	@Override
	public Remote lookup(String name) throws RemoteException, NotBoundException, AccessException {
		
		// TODO Auto-generated method stub
		
		Integer index = keyRemoteList_it.get(name);
		Remote stub = keyRemoteList.get(name).get(index);
		
		System.out.println("GlobalRegistry.lookup(): Returned the Stub correpsonding to the server n°" + index);
		
		if (index < keyRemoteList.get(name).size() - 1) {
			keyRemoteList_it.put(name, index + 1);
		} else {
			keyRemoteList_it.put(name, 0);
		}
		
		return stub;
	}

	/**
	 * Return a string array
	 */
	@Override
	public String[] list() throws RemoteException, AccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Return the stub list corresponding to one Service
	 */
	public List<Remote> list(String service) throws RemoteException, AccessException {
		return keyRemoteList.get(service);
	}
}
