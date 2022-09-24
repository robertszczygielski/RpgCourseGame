package com.eclipse.ec;

import com.eclipse.ec.domain.Forest;
import com.eclipse.ec.domain.OldCastle;
import com.eclipse.ec.enums.Places;
import com.eclipse.ec.enums.Weapons;
import com.eclipse.ec.repository.Warrior;
import com.eclipse.ec.services.ForestService;
import com.eclipse.ec.services.OldCastleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.stream.Stream;

// @SpringBootApplication
public class EcApplication {

//	public static void main(String[] args) {
//        SpringApplication.run(EcApplication.class, args);
//	}

    public static void maina(String[] args) {
        Optional<Object> nameOfWeapon = Stream.of(Weapons.values())
                .filter(it -> it.getExtraHit() == 5)
                .findFirst()
                .map(it -> it.name());
    }

    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        try {
            warrior.setName("Conan B.");
            warrior.setVisitedPlace(Places.GRAVEYARD);
            warrior.setWeapon(Weapons.STICK);
            warrior.setHitPoints(30);
            warrior.setInitiative(2);
        } catch (Exception e) {
            System.out.println("Your Warrior has to short name");
        }

        ForestService forestService = new ForestService();
        Forest forest = forestService.createForest();
        forest.fight(warrior);

    }
}
