package com.eclipse.ec.controllers;

import org.springframework.web.bind.annotation.*;

import com.eclipse.ec.domain.Forest;
import com.eclipse.ec.enums.Places;
import com.eclipse.ec.enums.Weapon;
import com.eclipse.ec.repository.Warrior;
import com.eclipse.ec.services.ForestService;

@RestController
public class GameController {

	private int enemiesNumber;
	private ForestService forestService = new ForestService();
	
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String getGameData() {
        return "my game data " + this.enemiesNumber;
    }

    @RequestMapping(value = "/game/{name}", method = RequestMethod.POST)
    @ResponseBody
    public String postGameData(@PathVariable("name") String name) {
        return "my game name: " + name;
    }
    
    @RequestMapping(value = "/game/enemies", method = RequestMethod.PUT)
	@ResponseBody
	public String putGameEnemies(@RequestParam("numb") int enemyNumb) {
		this.enemiesNumber = enemyNumb;
		return "set enemy numb: " + enemyNumb;
	}
    
    @RequestMapping(value = "/game/fight", method = RequestMethod.GET)
    public String getFightWithWarrior() {
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
        
        Forest forest = forestService.createForest();
        String resultFight = forest.fightInWeb(warrior);
        
        return resultFight;

    }


}
