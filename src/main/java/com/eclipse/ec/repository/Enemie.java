package com.eclipse.ec.repository;

public class Enemie implements Comparable<Enemie> {

	private int hitPoints;
	private int intiative;
	private String name;

	public Enemie(int hitPoints, int intiative, String name) {
		this.hitPoints = hitPoints;
		this.intiative = intiative;
		this.name = name;
	}

	public Enemie() {
		hitPoints = 2;
		intiative = 0;
		name = "NN";
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public void setHitPoints(String hitPoints) {
		this.hitPoints = Integer.valueOf(hitPoints);
	}

	public int getIntiative() {
		return intiative;
	}

	public void setIntiative(int intiative) {
		this.intiative = intiative;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Enemie a) {
		if (this.intiative < a.intiative ) return 1;
		if (this.intiative > a.intiative ) return -1;
		return 0; // jeśli są równe
	}

	@Override
	public String toString() {
		return "Enemie [hitPoints=" + hitPoints + ", intiative=" + intiative + ", name=" + name + "]";
	}
	
}
