package exercise3.server;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;

import exercise3.server.Registry;

public class Registry {

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
    LocateRegistry.createRegistry(REGISTRY_PORT);
    System.out.println("registry: listening on port " + REGISTRY_PORT);

    // block forever
    Registry.class.wait();
    System.out.println("registry: exiting (should not happen)");

  }
}
