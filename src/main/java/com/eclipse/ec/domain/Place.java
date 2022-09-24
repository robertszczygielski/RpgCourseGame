package com.eclipse.ec.domain;

public abstract class Place {
	public void showPlaceOfOccurrence() {
		String occurrence = getPlaceOfOccurrence();
		System.out.println("Enemy is occurred in " + occurrence);
	}

	abstract protected String getPlaceOfOccurrence();
}
