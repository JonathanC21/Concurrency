package com.valencia;

import java.util.Random;

/**
 * Contains methods that run two array summutations, one single threaded and one multithreaded
 */
public class Concurrency {
	
	static final int TWO_HUND_MILL = 200000000;
	static int[] hugeArray = new int[TWO_HUND_MILL];
	static Summation sum = new Summation();
	
	/**
	 * The main method of the program
	 * @param args
	 */
	public static void main(String args[]) {
		
		System.out.println("Filling up array with integers from 1-10...");
		hugeArray = fillArray(hugeArray);
		System.out.println("Array filled with 200 million integers!");
		
		System.out.println("Summing up array using one thread...");
		System.out.println("Sum: " + sum.singleThreadSum(hugeArray));
		System.out.println("Time: " + sum.getSingleThreadTime() + " nanoseconds");
		
		System.out.println("Summing up array using 4 threads...");
		System.out.println("Sum: " + sum.multiThreadSum(hugeArray));
		System.out.println("Time: " + sum.getMultiThreadTime() + " nanoseconds");
		
		System.out.println("The difference between the times is " + Math.abs((sum.getMultiThreadTime() - sum.getSingleThreadTime())) + " nanoseconds");
		System.exit(0);
	}
	
	/**
	 * Fills up an int[] array with integers ranging from 1 to 10
	 * 
	 * @param intArray
	 * @return Returns the int[] array filled up with integers
	 */
	static int[] fillArray(int[] intArray){
		
		Random rand = new Random();
		
		for (int i = 0; i < intArray.length; i++) {
			
			intArray[i] = rand.nextInt(10) + 1;
		}
		
		return intArray;	
	}
}
