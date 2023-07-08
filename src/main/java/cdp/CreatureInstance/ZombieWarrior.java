/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp.CreatureInstance;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author almei
 */
public class ZombieWarrior extends _Base {

    public ZombieWarrior(String name, int idCreature) {
        super(40, "Zombie Warrior", name, idCreature);
    }

    @Override
    public void attack(List sideA, List sideB) {
        _TypeLine instance = (_TypeLine) sideB.get(0);
        instance.loseEnergy(this.getPower());

        if (sideB.size() > 1) {
            instance = (_TypeLine) sideB.get(1);
            instance.loseEnergy(10);
            super.gainEnergy(10);
        }
    }

}
