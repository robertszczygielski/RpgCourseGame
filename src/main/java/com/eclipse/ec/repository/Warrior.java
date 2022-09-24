package com.eclipse.ec.repository;

import com.eclipse.ec.enums.Places;
import com.eclipse.ec.enums.Weapons;

public class Warrior {

    private String name;
    private Integer initiative;
    private Integer hitPoints;
    private Weapons weapon;
    private Places visitedPlace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Places getVisitedPlace() {
        return visitedPlace;
    }

    public void setVisitedPlace(Places visitedPlace) {
        this.visitedPlace = visitedPlace;
    }
}
