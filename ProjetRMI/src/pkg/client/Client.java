/**
 * @author Amélie GIRARD & Paul-Axel MARIE
 * @description Distributed System - Project RMI
 * @info EFREI - IL - P2017
 * @date 2016-12-20
 */

package pkg.client;

//import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;

import pkg.common.remote.Sorter;
import pkg.server.LocateGlobalRegistry;

/**
 * Client program.
 *
 * Note: For the the client to retrieve the stub of the remote object, it needs
 * to know: (1) what the name of the object is, (2) which machine hosts the
 * remote object.
 */
public class Client {

	/**
	 * Constants
	 * SERVICE_NAME
	 * SERVICE_HOST
	 */
	private static String SERVICE_NAME = "Sorter";
	private static String SERVICE_HOST = "localhost";

  	/**
  	 * MAIN
  	 * @param args
  	 * @throws Exception
  	 */
  	public static void main(String[] args) throws Exception {

  		// Locate the registry that runs on the remote object's server
  		Registry registry = LocateGlobalRegistry.getRegistry(SERVICE_HOST);
  		System.out.println("client: retrieved registry");

  		// Retrieve the stub of the remote object by its name
  		Sorter sorter = (Sorter) registry.lookup(SERVICE_NAME);
  		System.out.println("client: retrieved Sorter stub");

  		// call the remote object to perform sorts and reverse sorts
  		List<String> list = Arrays.asList("3", "5", "1", "2", "4");
  		System.out.println("client: sending " + list);

		list = sorter.sort(list);
		System.out.println("client: received sorted " + list);
		
		list = Arrays.asList("mars", "saturne", "neptune", "jupiter");
		System.out.println("client: sending " + list);
		
		list = sorter.reverseSort(list);
		System.out.println("client: received reverseSorted" + list);
		
		// main terminates here
		System.out.println("client: exiting");
  }
}
