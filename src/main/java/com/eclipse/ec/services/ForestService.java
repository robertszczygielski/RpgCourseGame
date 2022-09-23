package com.eclipse.ec.services;

import com.eclipse.ec.domain.Forest;
import com.eclipse.ec.repository.Zombe;
import com.eclipse.ec.repository.Enemie;

public class ForestService {

	public Forest createForest() {
		Forest forest = new Forest();
		Zombe teacharZombe = new Zombe();
		teacharZombe.setRegeneration(1);
		teacharZombe.setInitiative(20);
		teacharZombe.setHitPoints(2);
		teacharZombe.setName("Teacher Zombe");
		
		Enemie dogZombe = new Zombe();
		
		Enemie[] enemies = { teacharZombe, dogZombe };
		forest.setEnemies(enemies);
		
		return forest;
	}
	
}
