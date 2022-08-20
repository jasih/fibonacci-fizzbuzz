package com.cooksys.ftd.assignments.control;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two
 * elements are `1`, and every other element is equal to the sum of its two
 * preceding elements. For example:
 * <p>
 * [1, 1] => [1, 1, 1 + 1] => [1, 1, 2] => [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] => ...etc
 */
public class Fibonacci {

	/**
	 * Calculates the value in the Fibonacci sequence at a given index. For example,
	 * `atIndex(0)` and `atIndex(1)` should return `1`, because the first two
	 * elements of the sequence are both `1`.
	 *
	 * @param i the index of the element to calculate
	 * @return the calculated element
	 * @throws IllegalArgumentException if the given index is less than zero
	 */
	public static int atIndex(int i) throws IllegalArgumentException {

		int startIndex = 0; 									// I want to keep track of the generated Fibonacci numbers, so assign startIndex = 0, nextIndex = 1, and temp = 0
																
		int nextIndex = 1; 										// This is because atIndex(0) and atIndex(1) returns 1 and temp will keep track of the returned value
							
		int temp = 0;

		if (i < 0) { 											// Then check if the given index is less than zero, throw exception
			throw new IllegalArgumentException();
		} else if (i == 0) { 									// else if i is 0 then return 1;
			return 1; 											// else if i is 1 then return 1;
		} else if (i == 1) { 									// This is because the first two elements in the Fibonacci sequence is [1, 1]
			return 1;
		} else { 												// Else it will iterate through each index in the list (n) from 1 to i
			for (int n = 1; n <= i; n++) {
				temp = startIndex + nextIndex; 					// After it starts at the first and second element (which is [1, 1]), our										
				startIndex = nextIndex; 						// returned value will be stored in temp
				nextIndex = temp; 								// then it goes up the list and assign startIndex to nextIndex to check the next index
																// then the previous index (nextIndex) is now our new temporary (temp) value
			}													// The for loop will keep iterating through each index until we get our desired value at a given index
		}

		return temp; 											// then our returned value at a given index is temp, which is the sum of its two preceding elements

	}

	/**
	 * Calculates a slice of the fibonacci sequence, starting from a given start
	 * index (inclusive) and ending at a given end index (exclusive).
	 *
	 * @param start the starting index of the slice (inclusive)
	 * @param end   the ending index of the slice(exclusive)
	 * @return the calculated slice as an array of int elements
	 * @throws IllegalArgumentException if either the given start or end is
	 *                                  negative, or if the given end is less than
	 *                                  the given start
	 */
	public static int[] slice(int start, int end) throws IllegalArgumentException {

		int[] slicedArr = new int[0];									// First I created a new array to store the slice of the array and initialize it with 0 elements

		if (start < 0 || end < 0 || end < start) {						// Now check for the IllegelArgumentException error 
			throw new IllegalArgumentException();						// Throw it if any of the conditions are met
		} else {														// Else, find the range of elements we need to find
			slicedArr = new int[end - start];
			while (start < end) {										// While, the start is < end, meaning as long as it won't reach a negative array size
				for (int i = 0; i < slicedArr.length; i++) {			// Iterate through each index until we reach the end of the length of the array (which is the new array size)
					slicedArr[i] = atIndex(start);						// Using atIndex(n), I can calculate the value at the given start index in the Fibonacci sequence
					start = start + 1;									// Then, store that value in start and increment it by 1 to check the next value in the Fibonacci sequence
				//	System.out.println("start " + start);
				//	System.out.println("slice " + slicedArr[i]);
				}
			}

		}

		return slicedArr;												// Return the array slice
	}

	/**
	 * Calculates the beginning of the fibonacci sequence, up to a given count.
	 *
	 * @param count the number of elements to calculate
	 * @return the beginning of the fibonacci sequence, up to the given count, as an
	 *         array of int elements
	 * @throws IllegalArgumentException if the given count is negative
	 */
	public static int[] fibonacci(int count) throws IllegalArgumentException {
		
		int[] beginFib = new int[0];								// First make a new int array to store the beginning values of the Fib. sequence, up to a given count
		
		if (count < 0) {
			throw new IllegalArgumentException();					// Check if count is < 0, throw exception error
		} else {													// Else, find the the beginning values of the sequence
			beginFib = new int[count];
			for (int i = 0; i < count; i++) {						// Loop through the array, starting from start of the sequence (index 0) until the end of the sequence (count)
				beginFib[i] = atIndex(i);							// Store the value atIndex(i) into the array
			}														
		}															// Repeat until it reaches the given count (or the end)
		
		return beginFib;											// Return the array
	}
}
