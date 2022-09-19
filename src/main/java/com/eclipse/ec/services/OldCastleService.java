package com.eclipse.ec.services;

import com.eclipse.ec.domain.OldCastle;
import com.eclipse.ec.repository.Enemie;
import com.eclipse.ec.repository.Zombe;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OldCastleService {

    public OldCastle createForest() {
        OldCastle forest = new OldCastle();
        List<Enemie> enemies = IntStream.range(0, 2).mapToObj(idx -> {
            switch (idx % 3) {
                case 0: {
                    var z = new Zombe();
                    return z;
                }
                case 1: {
                    var z = new Zombe();
                    return z;
                }
                case 2: {
                    var z = new Zombe();
                    return z;
                }
                default:
                    return null;
            }
        }).collect(Collectors.toList());

        forest.setEnemies(enemies.toArray(Enemie[]::new));

        return forest;
    }

}
