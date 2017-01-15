/**
 * @author Amélie GIRARD & Paul-Axel MARIE
 * @description Distributed System - Project RMI
 * @info EFREI - IL - P2017
 * @date 2016-12-20
 */

package pkg.server;

import java.net.InetAddress;

/**
 * ServerRegistry
 * create a new Global Registry and wait for clients
 */
public class ServerRegistry {

	/**
	 * Constant REGISTRY_PORT
	 * Listening port for the registry
	 */
	private static final int REGISTRY_PORT = 1099;

	/**
     * MAIN - ServerRegistry
     * @param args
     * @throws Exception
     */
	public static synchronized void main(String[] args) throws Exception {

	    System.out.println("ServerRegistry: Running on host " + InetAddress.getLocalHost());

	    // Create the registry on the local machine, on the default port number
	    LocateGlobalRegistry.createRegistry();
	    System.out.println("ServerRegistry: Listening on port " + REGISTRY_PORT);
	    System.out.println();

	    // block forever
	    ServerRegistry.class.wait();
	    System.out.println("ServerRegistry: Exiting (Error: should not happen)");
	}
}
