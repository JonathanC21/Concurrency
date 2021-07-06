package com.valencia;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class FillArrayTest {

	@Test
	void test() {
		
		int[] testArray = new int[1];
		Concurrency.fillArray(testArray);
		assertTrue(testArray[0] > 0 && testArray[0] < 11);
	}
}
