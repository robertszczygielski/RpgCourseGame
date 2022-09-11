package com.eclipse.ec;

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
			warrior.setIntiative(20);
		} catch (Exception e) {
			System.out.println("Your Warrior has to short name");
		}
		
		ForestService forestService = new ForestService();
		Forest forest = forestService.createForest();
		forest.fight(warrior);
		
	}
}
