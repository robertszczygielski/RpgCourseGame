package com.eclipse.ec.controllers;

import com.eclipse.ec.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EnemiesController {

	private EnemyRepository enemyRepository;

	public EnemiesController(EnemyRepository enemyRepository) {
		this.enemyRepository = enemyRepository;
	}

	@RequestMapping(value = "/enemies", method = RequestMethod.GET)
	public ResponseEntity<List<Enemie>> getAllEnemies() {
		return new ResponseEntity<List<Enemie>>(enemyRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/enemies/byname", method = RequestMethod.GET)
	public ResponseEntity<List<Enemie>> getAllEnemiesByName(@RequestParam("name") String enemyName) {
		return new ResponseEntity<List<Enemie>>(enemyRepository.findAll().stream()
				.filter(it -> it.getName().equals(enemyName)).collect(Collectors.toList()), HttpStatus.OK);
	}


	@RequestMapping(value = "/enemies/add", method = RequestMethod.POST)
	@Transactional
	public String addEnemy(@RequestParam("name") String enemyName) {
		var e = new Enemie();
		e.setHitPoints(10);
		e.setInitiative(10);
		e.setName(enemyName);

		var et = new EnemyType();
		et.setName("W");
		var o = new Origin();
		o.setInitiative(2);
		o.setName("P");
		et.setOrigin(o);
		e.setEnemyType(et);

		var m = new Material();
		m.setInitiative(1);
		e.setImmunity(m);

		var w = new Weapon();
		w.setHitPoints(3);
		w.setMaterial(m);
		w.setName("WW");
		e.setWeapon(w);

		enemyRepository.save(e);
		return enemyName;
	}
}
