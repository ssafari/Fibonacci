package com.code.fib;

import org.springframework.stereotype.Service;

@Service
public class Calculus {

	/**
	 * Method for calculating fibonacci numbers.
	 * 
	 * @param n
	 * @return fib serie
	 */
	public int[] giveFibonnaciNum(int n) {
		if (n < 0)
			return null;

		// Array of Fibonacci numbers starts at 0. 
		int fib[] = new int[n+1];
		fib[0] = 0;
		
		// for value 0 no need any calculation
		if (n == 0) 
			return fib;

		// Second number is always 1
		fib[1] = 1;

		for (int i = 2; i <= n; i++) {
			/* Add the previous 2 numbers in the series and store it */
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib;
	}
}
