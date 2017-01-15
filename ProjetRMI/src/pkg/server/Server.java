/**
 * @author Amélie GIRARD & Paul-Axel MARIE
 * @description Distributed System - Project RMI
 * @info EFREI - IL - P2017
 * @date 2016-12-20
 */

package pkg.server;

import java.net.InetAddress;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import pkg.common.remote.Sorter;

/**
 * Server
 * Operate the remote methods
 */
public class Server {

	/**
	 * Constant SERVICE_NAME
	 */
	private static final String SERVICE_NAME = "Sorter";

	/**
	 * Main - Server
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {

	    // Check the name of the local machine (two methods)
	    System.out.println("Server: Running on host " + InetAddress.getLocalHost());
	    System.out.println("Server: Hostname property " + System.getProperty("java.rmi.server.hostname"));

	    // Instantiate the remote object
	    Sorter sorter = new SimpleSorter();
	    System.out.println("Server: Instanciated SimpleSorter");

	    // Create a skeleton and a stub for that remote object
	    Sorter stub = (Sorter) UnicastRemoteObject.exportObject(sorter, 0);
	    System.out.println("Server: Skeleton and Stub Generated for the '" + SERVICE_NAME + "' Service");

	    // Register the remote object's stub in the registry
	    Registry registry = LocateGlobalRegistry.getRegistry();
	    registry.bind(SERVICE_NAME, stub);
	    registry.bind(SERVICE_NAME, stub);
	    System.out.println("Server: The remote object's stub is now binded/registered");

	    // Main terminates here, but the JVM still runs because of the skeleton
	    System.out.println("Server: Ready - Skeleton waiting for stub requests");
	    System.out.println();
    }
}
