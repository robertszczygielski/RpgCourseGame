package com.eclipse.ec;

import com.eclipse.ec.domain.MountainsCharacter;
import com.eclipse.ec.domain.UnicornForest;
import com.eclipse.ec.services.UnicornForestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eclipse.ec.domain.Forest;
import com.eclipse.ec.enums.Places;
import com.eclipse.ec.enums.Wapens;
import com.eclipse.ec.repository.Warrior;
import com.eclipse.ec.services.ForestService;

// @SpringBootApplication
public class EcApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(EcApplication.class, args);
//	}

	public static void main(String[] args) {
		Warrior warrior = new Warrior();
		try {
			warrior.setName("Conan B.");
			warrior.setVisitedPalce(Places.GRAVEYARD);
			warrior.setWapen(Wapens.STICK);
			warrior.setHitPoints(30);
			warrior.setIntiative(2);
		} catch (Exception e) {
			System.out.println("Your Warrior has to short name");
		}
		
		UnicornForestService forestService = new UnicornForestService();
		UnicornForest forest = forestService.createForest(args[0], args[1]);
		forest.fight(warrior);
		
	}
}
