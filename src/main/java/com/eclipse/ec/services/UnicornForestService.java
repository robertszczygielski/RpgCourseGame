package com.eclipse.ec.services;

import com.eclipse.ec.builders.ZombeBuilder;
import com.eclipse.ec.domain.ForestCharacter;
import com.eclipse.ec.domain.MountainsCharacter;
import com.eclipse.ec.domain.UnicornForest;
import com.eclipse.ec.repository.Enemie;
import com.eclipse.ec.repository.StoneDragon;
import com.eclipse.ec.repository.Trol;
import com.eclipse.ec.repository.Zombe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnicornForestService {

    private Map<String, MountainsCharacter> mountainsEnemies;
    private Map<String, ForestCharacter> forestCharacter;

    public UnicornForestService() {
        this.mountainsEnemies = new HashMap<>();
        this.mountainsEnemies.put("Boss1", new Trol());
        this.mountainsEnemies.put("Boss2", new StoneDragon());

        this.forestCharacter = new HashMap<>();
        this.forestCharacter.put("Boss1", new Zombe());
        this.forestCharacter.put("Boss2", new Zombe());
    }

    public UnicornForest createForest(String placeName, String bossName) {
        UnicornForest forest;
        if (placeName.contains("forest")) {
            forest = new UnicornForest<ForestCharacter>();
            forest.setBoss(forestCharacter.get(bossName));
        } else {
            forest = new UnicornForest<MountainsCharacter>();
            forest.setBoss(mountainsEnemies.get(bossName));
        }

        Zombe teacharZombe = new Zombe();
        teacharZombe.setRegeneration(1);
        teacharZombe.setIntiative(20);
        teacharZombe.setHitPoints(2);
        teacharZombe.setName("Teacher Zombe");

        Zombe z = new ZombeBuilder()
                .withHitPoints(10)
                .withRegenerator(1)
                .build();


        Enemie dogZombe = new Zombe();
        Enemie stoneDragon = new StoneDragon();
        
        Enemie[] enemies = {teacharZombe, dogZombe, stoneDragon};
        forest.setEnemies(Arrays.asList(enemies));

        return forest;
    }

}
