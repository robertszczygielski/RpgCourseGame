package com.eclipse.ec.repository;

import com.eclipse.ec.enums.Places;
import com.eclipse.ec.enums.Wapens;

public class Warrior extends Character {
	
	private Wapens wapen;
	private Places visitedPalce;

	public Wapens getWapen() {
		return wapen;
	}

	public void setWapen(Wapens wapen) {
		this.wapen = wapen;
	}

	public Places getVisitedPalce() {
		return visitedPalce;
	}

	public void setVisitedPalce(Places visitedPalce) {
		this.visitedPalce = visitedPalce;
	}

}
