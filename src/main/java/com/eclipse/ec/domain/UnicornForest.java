package com.eclipse.ec.domain;

import com.eclipse.ec.repository.Enemie;
import com.eclipse.ec.repository.Warrior;

import java.util.List;

public class UnicornForest<T> extends Place implements Occurenable {

    private List<Enemie> enemies;
    private T boss;

    public UnicornForest() {
    }

    public T getBoss() {
        return boss;
    }

    public void setBoss(T boss) {
        this.boss = boss;
    }

    public List<Enemie> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemie> enemies) {
        this.enemies = enemies;
    }
    
    public void setEnemies(Enemie characere) {
        this.enemies.add(characere);
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
        System.out.println("Now you see " + enemies.size() + " enemies");
        System.out.print("they names are: ");
        for (Enemie enemy : enemies) {
            System.out.print(enemy + ", ");
        }
        System.out.println();
        System.out.println("========================================================");
        System.out.println("Fight: ");

        for (Enemie enemy : enemies) {
            if (enemy.compareTo(warrior) > 0) {
                int warriorHit = warrior.getHitPoints() - warrior.getWeapon().getExtraHit();
                int hp = enemy.getHitPoints() - warriorHit;
                enemy.setHitPoints(hp);
            } else {
                int hp = warrior.getHitPoints() - enemy.getHitPoints();
                System.out.println("You was wonded, HP = " + hp);
                warrior.setHitPoints(hp);
            }

            if (enemy.getHitPoints() < 0) {
                System.out.println("You have defited " + enemy);
            }
        }
        
        fightWithBoss(warrior);
    }

    private void fightWithBoss(Warrior warrior) {
        Enemie boss = (Enemie) this.boss;
        if (boss.getInitiative() <= warrior.getInitiative()) {
            int hp = boss.getHitPoints() - (warrior.getHitPoints() + warrior.getWeapon().getExtraHit());
            boss.setHitPoints(hp);
            if (boss.getHitPoints() < 0) {
                System.out.println("You have defeated BOSS");
            }
        } else {
            int hp = warrior.getHitPoints() - boss.getHitPoints();
            warrior.setHitPoints(hp);
            if (warrior.getHitPoints() < 0) {
                System.out.println("You are defeated");
            }
        }
    }
}
