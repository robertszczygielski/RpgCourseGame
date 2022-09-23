package com.eclipse.ec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eclipse.ec.fizzbuzz.FizzBuzzService;
import com.eclipse.ec.fizzbuzz.NumbersRepository;

@ExtendWith(MockitoExtension.class)
public class MockitoFizzBuzzTest {
	
	private FizzBuzzService fb;
	private NumbersRepository numbersRepository;

	@BeforeEach
	public void setup() {
		
		numbersRepository = Mockito.mock(NumbersRepository.class);
		fb = new FizzBuzzService(numbersRepository);

	}
	
	@Test
	public void shoulReturn1For1() {
		// given
		int one = 1;
			
		Mockito.when(numbersRepository.getNumbersToMap())
											.thenReturn(Arrays.asList(one));

		// when
		List<String> result = fb.mapFromRepository();

		// then
		assertEquals("1", result.get(0));
	}
	
}
