package server;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class MyRegistry {

	//
	  // CONSTANTS
	  //
	  // default listening port for the registry
	  private static final int REGISTRY_PORT = 1099;

	  //
	  // MAIN
	  //
	  public static synchronized void main(String[] args) throws Exception {

	    System.out
	            .println("registry: running on host " + InetAddress.getLocalHost());

	    // create the registry on the local machine, on the default port number
	    LocateGlobalRegistry.createRegistry();
	    System.out.println("registry: listening on port " + REGISTRY_PORT);

	    // block forever
	    MyRegistry.class.wait();
	    System.out.println("registry: exiting (should not happen)");

	  }
}
