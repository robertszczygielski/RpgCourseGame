package com.eclipse.ec.domain;

import com.eclipse.ec.repository.Character;
import com.eclipse.ec.repository.Warrior;

public class Forest extends Place implements Occurenable {

	private Character[] enemies;

	public Forest() {
	};

	public Forest(int enemiesAmoutn) {
		enemies = new Character[enemiesAmoutn];
	}

	public Character[] getEnemies() {
		return enemies;
	}

	public void setEnemies(Character[] enemies) {
		this.enemies = enemies;
	}

	public void setEnemies(Character characere, int idx) {
		this.enemies[idx] = characere;
	}

	@Override
	protected String getPlaceOfOccurrence() {
		return "Forest";
	}

	@Override
	public String occurenceAtTimeOfDay() {
		return "Midnight";
	}

	public void fight(Warrior warrior) {
		System.out.println("Now you see " + enemies.length + " enemies");
		System.out.print("they names are: ");
		for (Character enemy : enemies) {
			System.out.print(enemy.getName() + ", ");
		}
		System.out.println();
		System.out.println("========================================================");
		System.out.println("Fight: ");

		for (Character enemy : enemies) {
			if ((enemy.getIntiative()) <= warrior.getIntiative()) {
				int warriorHit = warrior.getHitPoints() - warrior.getWapen().getExtraHit();
				int hp = enemy.getHitPoints() - warriorHit;
				enemy.setHitPoints(hp);
			} else {
				int hp = warrior.getHitPoints() - enemy.getHitPoints();
				System.out.println("You was wonded, HP = " + hp);
				warrior.setHitPoints(hp);
			}

			if (enemy.getHitPoints() < 0) {
				System.out.println("You have defited " + enemy.getName());
			}

		}
	}
}
