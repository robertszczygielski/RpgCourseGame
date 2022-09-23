package com.eclipse.ec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import com.eclipse.ec.fizzbuzz.FizzBuzzService;


public class FizzBuzzTest {
	
	private FizzBuzzService fb = new FizzBuzzService();
	
	@Test
	public void shoulReturn1For1() {
		// given
		int one = 1;
		
		// when
		String result = fb.map(one);
		
		// then
		assertEquals("1", result);
	}
	
	@Test
	public void shoulReturnFizzFor3() {
		// given
		int three = 3;
		
		// when
		String result = fb.map(three);
		
		// then
		assertEquals("Fizz", result);
	}
	
	@Test
	public void shoulReturnBuzzFor5() {
		// given
		int five = 5;
		
		// when
		String result = fb.map(five);
		
		// then
		assertEquals("Buzz", result);
	}
	
	@Test
	public void shoulReturnFizzBuzzFor15() {
		// given
		int fifteen = 15;
		
		// when
		String result = fb.map(fifteen);
		
		// then
		assertEquals("FizzBuzz", result);
	}
	
	@Test
	public void regexTest1() {
		Pattern pattern = Pattern.compile("Sii", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("Kurs Sii z Javy");
		boolean matchFound = matcher.find();
		if (matchFound) {
			System.out.println("Match found");
		} else {
			System.out.println("Match not found");
		}
	}
	
	@Test
	public void regexTest2() {
		String paternToFind = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(paternToFind, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("JakisAdres@mail.complpl");
		boolean matchFound = matcher.find();
		if (matchFound) {
			System.out.println("Email found");
		} else {
			System.out.println("Email not found");
		}
	}
}
