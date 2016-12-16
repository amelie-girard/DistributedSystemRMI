package exercise3.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import exercise3.PropertyRepository;

public class Client2 {
	 //
	  // CONSTANTS
	  //
	  private static String SERVICE_NAME = "PropertyRepository";
	  private static String SERVICE_HOST = "localhost";

	  //
	  // MAIN
	  //
	  public static void main(String[] args) throws Exception {

	    // locate the registry that runs on the remote object's server
	    Registry registry = LocateRegistry.getRegistry(SERVICE_HOST);
	    System.out.println("client: retrieved registry");

	    // retrieve the stub of the remote object by its name
	    PropertyRepository repository = (PropertyRepository) registry.lookup(SERVICE_NAME);
	    System.out.println("client: retrieved Repository stub");

	    // call the remote object to perform sorts and reverse sorts
	

	    System.out.println("client sending (Paris, Eiffel Tower)");
	   	repository.setProperty("Paris", "Eiffel Tower");
	   	String s  = repository.getProperty("Paris");

	    System.out.println("client: received " + s);

	  
	 

	    repository.removeProperty("Paris");
	    String s2 = repository.getProperty("Paris");
	    System.out.println("client: received " + s2);

	    // main terminates here
	    System.out.println("client: exiting");

	  }

}
