package com.valencia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiThreadSumTest {

	@Test
	void test() {
		int[] testArray = {1,2,3};
		
		Summation test = new Summation();
		assertEquals(6,test.multiThreadSum(testArray));
	}

}
