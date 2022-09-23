package com.eclipse.ec.domain;

import com.eclipse.ec.repository.Enemie;
import com.eclipse.ec.repository.Warrior;

public class Forest extends Place implements Occurenable {

	private Enemie[] enemies;

	public Forest() {
	};

	public Forest(int enemiesAmount) {
		enemies = new Enemie[enemiesAmount];
	}

	public Enemie[] getEnemies() {
		return enemies;
	}

	public void setEnemies(Enemie[] enemies) {
		this.enemies = enemies;
	}

	public void setEnemies(Enemie character, int idx) {
		this.enemies[idx] = character;
	}

	@Override
	protected String getPlaceOfOccurrence() {
		return "Forest";
	}

	@Override
	public String occurrenceAtTimeOfDay() {
		return "Midnight";
	}

	public void fight(Warrior warrior) {
		System.out.println("Now you see " + enemies.length + " enemies");
		System.out.print("they names are: ");
		for (Enemie enemy : enemies) {
			System.out.print(enemy.getName() + ", ");
		}
		System.out.println();
		System.out.println("========================================================");
		System.out.println("Fight: ");

		for (Enemie enemy : enemies) {
			if ((enemy.getInitiative()) <= warrior.getInitiative()) {
				int warriorHit = warrior.getHitPoints() - warrior.getWeapon().getExtraHit();
				int hp = enemy.getHitPoints() - warriorHit;
				enemy.setHitPoints(hp);
			} else {
				int hp = warrior.getHitPoints() - enemy.getHitPoints();
				System.out.println("You was wounded, HP = " + hp);
				warrior.setHitPoints(hp);
			}

			if (enemy.getHitPoints() < 0) {
				System.out.println("You have defeated " + enemy.getName());
			}

		}
	}

	public String fightInWeb(Warrior warrior) {
		StringBuilder sb = new StringBuilder();
		sb.append("Now you see " + enemies.length + " enemies");
		sb.append("they names are: ");
		for (Enemie enemy : enemies) {
			sb.append(enemy.getName() + ", ");
		}
		sb.append("========================================================");
		sb.append("Fight: ");

		for (Enemie enemy : enemies) {
			if ((enemy.getInitiative()) <= warrior.getInitiative()) {
				int warriorHit = warrior.getHitPoints() - warrior.getWeapon().getExtraHit();
				int hp = enemy.getHitPoints() - warriorHit;
				enemy.setHitPoints(hp);
			} else {
				int hp = warrior.getHitPoints() - enemy.getHitPoints();
				sb.append("You was wounded, HP = " + hp);
				warrior.setHitPoints(hp);
			}

			if (enemy.getHitPoints() < 0) { 
				sb.append("You have defeated " + enemy.getName());
			}
		}
		return sb.toString();
	}
}
