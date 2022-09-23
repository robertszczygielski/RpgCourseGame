package com.eclipse.ec;

import com.eclipse.ec.domain.OldCastle;
import com.eclipse.ec.enums.Places;
import com.eclipse.ec.enums.Wapens;
import com.eclipse.ec.repository.Warrior;
import com.eclipse.ec.services.OldCastleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.stream.Stream;

 @SpringBootApplication
public class EcApplication {

	public static void main(String[] args) {
        SpringApplication.run(EcApplication.class, args);
	}

    public static void mainA(String[] args) {
        Optional<Object> nameOfWapen = Stream.of(Wapens.values())
                .filter(it -> it.getExtraHit() == 5)
                .findFirst()
                .map(it -> it.name());
    }

    public static void main1(String[] args) {
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

        OldCastleService forestService = new OldCastleService();
        OldCastle forest = forestService.createForest();
        forest.fight(warrior);

    }
}
