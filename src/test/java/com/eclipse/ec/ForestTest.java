package com.eclipse.ec;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import com.eclipse.ec.domain.Forest;
import com.eclipse.ec.enums.Places;
import com.eclipse.ec.enums.Weapon;
import com.eclipse.ec.repository.Warrior;
import com.eclipse.ec.services.ForestService;

public class ForestTest {

	private ForestService forestService = new ForestService();
	
	@Test
	public void shouldReturnFightStirngWithTeacherZombeAsEnemy() {
		// given
		Warrior warrior = prepareWarrior();
        Forest forest = forestService.createForest();
        Pattern pattern = Pattern.compile("Teacher Zombe", Pattern.CASE_INSENSITIVE);
		        
		// when
        String resultFight = forest.fightInWeb(warrior);
		
		// then
        Matcher matcher = pattern.matcher(resultFight);
		assertTrue(matcher.find());
        
		
	}
	
	private Warrior prepareWarrior() {
		Warrior warrior = new Warrior();
        try {
            warrior.setName("Conan B.");
            warrior.setVisitedPlace(Places.GRAVEYARD);
            warrior.setWeapon(Weapon.STICK);
            warrior.setHitPoints(30);
            warrior.setInitiative(2);
        } catch (Exception e) {
            System.out.println("Your Warrior has to short name");
        }
        
        return warrior;
	}
	
}
