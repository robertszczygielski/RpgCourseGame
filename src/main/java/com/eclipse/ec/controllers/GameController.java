package com.eclipse.ec.controllers;

import org.springframework.web.bind.annotation.*;

import com.eclipse.ec.domain.Forest;
import com.eclipse.ec.enums.Places;
import com.eclipse.ec.enums.Wapens;
import com.eclipse.ec.repository.Warrior;
import com.eclipse.ec.services.ForestService;

@RestController
public class GameController {

	private int enemiesNumber;
	private ForestService forestService = new ForestService();
	
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String getGemeData() {
        return "my game data " + this.enemiesNumber;
    }

    @RequestMapping(value = "/game/{name}", method = RequestMethod.POST)
    @ResponseBody
    public String postGemeData(@PathVariable("name") String name) {
        return "my game name: " + name;
    }
    
    @RequestMapping(value = "/game/enemies", method = RequestMethod.PUT)
	@ResponseBody
	public String putGemeEnemies(@RequestParam("numb") int enemyNumb) {
		this.enemiesNumber = enemyNumb;
		return "set enemy numb: " + enemyNumb;
	}
    
    @RequestMapping(value = "/game/fight", method = RequestMethod.GET)
    public String getFightWithWarrior() {
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
        
        Forest forest = forestService.createForest();
        String resultFight = forest.fightInWeb(warrior);
        
        return resultFight;

    }


}
