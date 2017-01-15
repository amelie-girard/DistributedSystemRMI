/**
 * @author Amélie GIRARD & Paul-Axel MARIE
 * @description Distributed System - Project RMI
 * @info EFREI - IL - P2017
 * @date 2016-12-20
 */

package pkg.server;

import java.util.Collections;
import java.util.List;

import pkg.common.remote.Sorter;

/**
 * SimpleSorter
 * A Remote implementation that define 2 sorting methods
 */
public class SimpleSorter implements Sorter {

	/**
	 * Sort a String List
	 * 
	 * @return {List<String>} The sorted list
	 * @param {List<String>} list - The list to Sort
	 */
	public List<String> sort(List<String> list) {
		
		System.out.println("Server: Starting Process");
		System.out.println(this + ": receveid " + list);
		Collections.sort(list);
		System.out.println(this + ": returning " + list);
		System.out.println("Server: Ready - Skeleton waiting for stub requests");
		System.out.println();
		return list;
	}

	/**
	 * Reverse Sort a String List
	 * 
	 * @return {List<String>} The sorted list
	 * @param {List<String>} list - The list to Sort
	 */
	public List<String> reverseSort(List<String> list) {
		
		System.out.println("Server: Starting Process");
		System.out.println(this + ": receveid " + list);
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(this + ": returning " + list);
		System.out.println("Server: Ready - Skeleton waiting for stub requests");
		System.out.println();
		return list;
	}

	@Override
	public String toString() {
		return "SimpleSorter " + Thread.currentThread();
	}
}
