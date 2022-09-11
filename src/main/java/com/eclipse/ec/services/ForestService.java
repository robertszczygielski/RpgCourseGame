package com.eclipse.ec.services;

import com.eclipse.ec.domain.Forest;
import com.eclipse.ec.repository.Zombe;
import com.eclipse.ec.repository.Character;

public class ForestService {

	public Forest createForest() {
		Forest forest = new Forest();
		Zombe teacharZombe = new Zombe();
		teacharZombe.setRegeneration(1);
		teacharZombe.setIntiative(20);
		teacharZombe.setHitPoints(2);
		teacharZombe.setName("Teacher Zombe");
		
		Character dogZombe = new Zombe();
		
		Character[] enemies = { teacharZombe, dogZombe };
		forest.setEnemies(enemies);
		
		return forest;
	}
	
}
