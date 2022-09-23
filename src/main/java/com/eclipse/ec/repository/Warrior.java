package com.eclipse.ec.repository;

import com.eclipse.ec.enums.Places;
import com.eclipse.ec.enums.Weapon;

public class Warrior extends Enemie {
	
	private Weapon weapon;
	private Places visitedPlace;

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Places getVisitedPlace() {
		return visitedPlace;
	}

	public void setVisitedPlace(Places visitedPlace) {
		this.visitedPlace = visitedPlace;
	}

}
