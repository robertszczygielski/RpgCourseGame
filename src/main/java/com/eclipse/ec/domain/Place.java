package com.eclipse.ec.domain;

public abstract class Place {
	public void showPlaceOfOccurrence() {
		String occurre = getPlaceOfOccurrence();
		System.out.println("Enemy is occure in " + occurre);
	}

	abstract protected String getPlaceOfOccurrence();
}
