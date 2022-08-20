package com.cooksys.ftd.assignments.control;

import java.util.Arrays;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * FizzBuzz is an old programming exercise.
 * The goal is to iterate over a range of numbers and print a message about each number's divisibility.
 * <p>
 * The message is generated the following way:
 * *) if the number is divisible by three, the message is `Fizz`
 * *) if the number is divisible by five, the message is `Buzz`
 * *) if the number is divisible by both three and five, the message is `FizzBuzz`
 * *) otherwise, no message is produced
 * <p>
 * The exact message format for this assignment is specified in the `message(n)` method.
 */
public class FizzBuzz {

    /**
     * Checks whether a given int `a` is evenly divisible by a given int `b` or not.
     * For example, `divides(4, 2)` returns `true` and `divides(4, 3)` returns `false`.
     *
     * @param a the number to be divided
     * @param b the number to divide by
     * @return `true` if a is evenly divisible by b, `false` otherwise
     * @throws IllegalArgumentException if b is zero
     */
    public static boolean divides(int a, int b) throws IllegalArgumentException {
    															// Note: % operator returns the remainder after division
																// If a % b = 0, then the remainder = 0, and a is divisible by b
    	
    	if (b == 0) {											// Check if b = 0 throw exception
        	throw new IllegalArgumentException();	
        } else if (a % b == 0) {								// Else if 'a' is divisible by 'b' then return true
        	return true;
        }  
        
        return false;											// else return false if a is not divisible by b
    }

    /**
     * Generates a divisibility message for a given number. Returns null if the given number is not divisible by 3 or 5.
     * Message formatting examples:
     * 1 -> null // not divisible by 3 or 5
     * 3 -> "3: Fizz" // divisible by only 3
     * 5 -> "5: Buzz" // divisible by only 5
     * 15 -> "15: FizzBuzz" // divisible by both three and five
     *
     * @param n the number to generate a message for
     * @return a message according to the format above, or null if n is not divisible by either 3 or 5
     */
    public static String message(int n) {						
    	
    	 if (n % 3 != 0 && n % 5 != 0) {                            // First, check if n is NOT divisible by 3 AND 5, then return null
             return null;
         } else if (n % 3 == 0 && n % 5 == 0) {                   	// Else if n is divisible by 3 and 5, then return 'FizzBuzz'
             return n + ": FizzBuzz";                                
         } else if (n % 3 == 0) {                                	// Else if n is only divisible by 3, then return 'Fizz'
             return n + ": Fizz";
         } else if (n % 5 == 0) {                               	// Else if n is only divisible by 5, then return 'Buzz'
             return n + ": Buzz";
         }
      
         return "";                                                	// Else return nothing
    }

    /**
     * Generates an array of messages to print for a given range of numbers.
     * If there is no message for an individual number (i.e., `message(n)` returns null),
     * it should be excluded from the resulting array.
     *
     * @param start the number to start with (inclusive)
     * @param end the number to end with (exclusive)
     * @return an array of divisibility messages
     * @throws IllegalArgumentException if the given end is less than the given start
     */
    public static String[] messages(int start, int end) throws IllegalArgumentException {									
    
    	int count = 0;														
        String[] m;
     
        if (end < start) {											// Throw exception if end < start
            throw new IllegalArgumentException();
        } else {													// Else, find the array of messages given a range of numbers
            m = new String[end - start];
            for (int i = start; i <= end - 1; i++) {				// Loop through to calculate the values given the range of numbers
                if (message(i) != null) {
                    m[count] = message(i);
                    count++;										// Repeat until the end of the range
                }
            }
            String[] n = new String[count];							// Because we can't change the size of array that was already created, 
            int count1 = 0;											// create another array to populate only the values with no null values
            for (int i = 0; i <= n.length - 1; i++) {
                if(m[i] != null) {									// Loop through until the end of the length of the new array
                    n[count1] = m[i];
                    count1++;
                }
            }
            return n;												// Return the array
        }
    }		

    /**
     * For this main method, iterate over the numbers 1 through 115 and print
     * the relevant messages to sysout
     */
    public static void main(String[] args) {
    	

    	System.out.println(messages(1, 115));
    	
    
    }
}
