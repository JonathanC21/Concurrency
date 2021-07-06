package com.valencia;

import java.util.Arrays;

/**
 * Contains methods that sums up an array using both single and multithreading and measures the time to do so 
 */
public class Summation {
	
	private int multiThreadSum = 0;
	private long singleThreadTime = 0;
	private long multiThreadTime = 0;
	
	/**
	 * Finds the sum of all of the elements of a given int[] array using a single thread
 	 * 
	 * @param intArray The int[] array to be summed up
	 * @return Returns the sum of the int[] array
	 */
	public int singleThreadSum(int[] intArray) {
		
		int sum = 0;
		long startTime = System.nanoTime();
		
		for (int i = 0; i < intArray.length; i++) {
			
			sum += intArray[i];
		}
		
		singleThreadTime = System.nanoTime() - startTime;
		return sum;
	}
	
	/**
	 * Finds the sum of all of the elements of a given int[] array using 4 threads. The array is split into four to be used by each thread to process the sum in parallel.
 	 * 
	 * @param intArray The int[] array to be summed up
	 * @return Returns the sum of the int[] array
	 */
	public int multiThreadSum(int[] intArray) {
		
		int[] firstArray = Arrays.copyOfRange(intArray, 0, intArray.length/2);
		int[] secondArray = Arrays.copyOfRange(intArray,intArray.length/2, intArray.length);	
		int[] thirdArray = Arrays.copyOfRange(firstArray, 0, firstArray.length/2);
		int[] fourthArray = Arrays.copyOfRange(firstArray,firstArray.length/2, firstArray.length);
		int[] fithArray = Arrays.copyOfRange(secondArray, 0, secondArray.length/2);
		int[] sixthArray = Arrays.copyOfRange(secondArray,secondArray.length/2, secondArray.length);
		
		
		Thread t1 = new Thread (new Runnable() {

			@Override
			public void run() {
				
				multiSum(thirdArray);
			}
		});
		
		Thread t2 = new Thread (new Runnable() {

			@Override
			public void run() {
				multiSum(fourthArray);
			}
		});
		
		Thread t3 = new Thread (new Runnable() {

			@Override
			public void run() {
				
				multiSum(fithArray);
			}
		});
		
		Thread t4 = new Thread (new Runnable() {

			@Override
			public void run() {
				multiSum(sixthArray);
			}
		});
		
		long startTime = System.nanoTime();
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		try {
			
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			
			multiThreadTime = System.nanoTime() - startTime;
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return multiThreadSum;
	}
	
	/**
	 * Adds the values from a partitioned array to the total sum. Is synchronized to ensure accuracy when used by threads
	 * 
	 * @param intArray The partial int[] array to be summed up
	 */
	private synchronized void multiSum(int[] intArray) {
		
		for (int i = 0; i < intArray.length; i++) {
			
			multiThreadSum += intArray[i];
		}
	}
	 
	/**
	 * Accessor method for finding the time taken to calculate the sum of an int[] array using a single thread
	 * 
	 * @return Returns the long elapsed time
	 */
	public long getSingleThreadTime() {
		
		return singleThreadTime;
	}
	
	/**
	 * Accessor method for finding the time taken to calculate the sum of an int[] array using multiple threads
	 * 
	 * @return Returns the long elapsed time
	 */
	public long getMultiThreadTime() {
		
		return multiThreadTime;
	}
}
