package com.eclipse.ec.repository;

public class Enemie implements Comparable<Enemie> {

	private int hitPoints;
	private int initiative;
	private String name;

	public Enemie(int hitPoints, int initiative, String name) {
		this.hitPoints = hitPoints;
		this.initiative = initiative;
		this.name = name;
	}

	public Enemie() {
		hitPoints = 2;
		initiative = 0;
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

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Enemie a) {
		if (this.initiative < a.initiative) return 1;
		if (this.initiative > a.initiative) return -1;
		return 0; // jeśli są równe
	}

	@Override
	public String toString() {
		return "Enemie [hitPoints=" + hitPoints + ", initiative=" + initiative + ", name=" + name + "]";
	}
	
}
