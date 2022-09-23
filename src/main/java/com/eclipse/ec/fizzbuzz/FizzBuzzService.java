package com.eclipse.ec.fizzbuzz;

import java.util.List;

public class FizzBuzzService {
	
	private NumbersRepository numbersRepository;
	
	public FizzBuzzService() {}

	public FizzBuzzService(NumbersRepository numbersRepository) {
		this.numbersRepository = numbersRepository;
	}

	public List<String> mapFromRepository() {
		List<Integer> numbers = numbersRepository.getNumbersToMap();
		return List.of(map(numbers.get(0)));
	}

	
	public String map(int number) {
		StringBuilder sb = new StringBuilder();
		if (number % 3 == 0) { 
			sb.append("Fizz");
		}
		if (number % 5 == 0) { 
			sb.append("Buzz");
		}
		
		return sb.isEmpty() ? number + "" : sb.toString();
	}
}
