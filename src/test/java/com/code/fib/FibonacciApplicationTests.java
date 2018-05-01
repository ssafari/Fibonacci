package com.code.fib;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = MathController.class, secure = false)
//@SpringBootTest
public class FibonacciApplicationTests {
 
	@Autowired
	private MockMvc mockMvc;
	
    @MockBean
    Calculus service;
    
    @Test
    public void testNegative() throws Exception {
    	System.out.println("Test Negative");
    	Mockito.when(service.giveFibonnaciNum(Mockito.anyInt())).thenReturn(null);
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/fibonacci/number/-3").accept(
				MediaType.ALL_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expected = "Error, Negative number!";
    	
		assertEquals(expected, result.getResponse()
				.getContentAsString());
    }
    
    @Test
    public void testNumbers() throws Exception {
    	System.out.println("Test numbers");
    	Mockito.when(service.giveFibonnaciNum(Mockito.anyInt())).thenReturn(new int[] {0,1,1,2});
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/fibonacci/number/2").accept(
				MediaType.TEXT_PLAIN_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expected = "Fibonacci serie: [0, 1, 1, 2]";
    	
		assertEquals(expected, result.getResponse().getContentAsString());
    }
	@Test
	public void contextLoads() {
	}

}
