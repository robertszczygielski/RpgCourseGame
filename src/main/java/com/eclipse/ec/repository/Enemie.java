package com.eclipse.ec.repository;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "enemy")
public class Enemie implements Comparable<Enemie> {

	@Id
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	private Integer id;
	private String name;
	private Integer initiative;
	@Column(name = "hit_points")
	private Integer hitPoints;
	@JoinColumn(name = "enemy_type_id", insertable = true, updatable = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private EnemyType enemyType;
	@JoinColumn(name = "weapon_id", insertable = true, updatable = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private Weapon weapon;
	@JoinColumn(name = "immunity", insertable = true, updatable = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private Material immunity;

	public Enemie() {
	}

	public Enemie(Integer id,
				  String name,
				  Integer initiative,
				  Integer hitPoints,
				  EnemyType enemyType,
				  Weapon weapon,
				  Material immunity) {
		this.id = id;
		this.name = name;
		this.initiative = initiative;
		this.hitPoints = hitPoints;
		this.enemyType = enemyType;
		this.weapon = weapon;
		this.immunity = immunity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public EnemyType getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(EnemyType enemyType) {
		this.enemyType = enemyType;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Material getImmunity() {
		return immunity;
	}

	public void setImmunity(Material immunity) {
		this.immunity = immunity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Enemie enemie = (Enemie) o;
		return Objects.equals(id, enemie.id) && Objects.equals(name, enemie.name) &&
				Objects.equals(initiative, enemie.initiative) &&
				Objects.equals(hitPoints, enemie.hitPoints) &&
				Objects.equals(enemyType, enemie.enemyType) && Objects.equals(weapon, enemie.weapon) &&
				Objects.equals(immunity, enemie.immunity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, initiative, hitPoints, enemyType, weapon, immunity);
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
