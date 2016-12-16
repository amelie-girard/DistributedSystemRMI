package server;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalRegistry implements Registry {
	
	
	private Map<String, List<Remote>> map = new HashMap<>();
	private Map <String, Integer> map_it = new HashMap<>(); //Map pour save les iterateurs


	@Override
	public void bind(String name, Remote obj) throws RemoteException, AlreadyBoundException, AccessException {
		// TODO Auto-generated method stub
		List<Remote> list = map.get(name);
		if (list == null){
			list = new ArrayList<>();
			map.put(name, list);
			map_it.put(name,0);
		}
		list.add(obj);
		
	}

	@Override
	public String[] list() throws RemoteException, AccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Remote lookup(String name) throws RemoteException, NotBoundException, AccessException {
		// TODO Auto-generated method stub
		System.out.println("map_it : "+map_it.get(name));
		Remote obj = map.get(name).get(map_it.get(name));
		
		
		if (map_it.get(name) < map.get(name).size()-1){
			map_it.put(name, map_it.get(name)+1);
		} else {
			map_it.put(name, 0);
		}
		
		return obj;
	}

	@Override
	public void rebind(String name, Remote obj) throws RemoteException, AccessException {
		// TODO Auto-generated method stub
		List<Remote> list = map.get(name);
		if (list == null){
			list = new ArrayList<>();
			map.put(name, list);
			map_it.put(name,0);
		}
		list.add(obj);
	}

	@Override
	public void unbind(String name) throws RemoteException, NotBoundException, AccessException {
		// TODO Auto-generated method stub
		
	}

}
