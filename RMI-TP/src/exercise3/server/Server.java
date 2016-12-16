package exercise3.server;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import exercise1.Sorter;
import exercise1.server.SimpleSorter;
import exercise3.PropertyRepository;


public class Server {
	 //
	  // CONSTANTS
	  //
	  private static final String SERVICE_NAME = "PropertyRepository";

	  //
	  // MAIN
	  //
	  public static void main(String[] args) throws Exception {

	    // check the name of the local machine (two methods)
	    System.out.println("server: running on host " + InetAddress.getLocalHost());
	    System.out.println("server: hostname property "
	            + System.getProperty("java.rmi.server.hostname"));

	    // instanciate the remote object
	    PropertyRepository repository = new Repository();
	    System.out.println("server: instanciated Repository");

	    // create a skeleton and a stub for that remote object
	    PropertyRepository stub = (PropertyRepository) UnicastRemoteObject.exportObject(repository, 0);
	    System.out.println("server: generated skeleton and stub");

	    // register the remote object's stub in the registry
	    Registry registry = LocateRegistry.getRegistry();
	    registry.rebind(SERVICE_NAME, stub);
	    System.out.println("server: registered remote object's stub");

	    // main terminates here, but the JVM still runs because of the skeleton
	    System.out.println("server: ready");

	  }


}
