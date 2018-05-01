package com.code.fib;


import java.io.IOError;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathController {

	@Autowired
	private Calculus genie;
	
	@GetMapping("/fibonacci/number/{num}")
	public ResponseEntity<String> fibonacciNumber(@PathVariable(value="num") String number) {
		try {
			int n = Integer.parseInt(number);
			int[] fib = genie.giveFibonnaciNum(n);
			if (fib != null) {
				String fib_serie = Arrays.toString(fib);
				return new ResponseEntity<String>("Fibonacci serie: "+fib_serie, HttpStatus.OK);
			}
			return new ResponseEntity<String>("Error, Negative number!", HttpStatus.NOT_ACCEPTABLE);
		} catch (NumberFormatException e) {
			System.out.println("Error ...."+e);
		}
		return new ResponseEntity<String>("Error, Not integer number!", HttpStatus.NOT_ACCEPTABLE);
	}
}
