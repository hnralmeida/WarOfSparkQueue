/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp.CreatureInstance;

import java.util.List;

/**
 *
 * @author almei
 */
public class Gideon extends _Base {

    public Gideon(String name, int idCreature) {
        super( 30, name, idCreature);
        this.type = "Planneswalker ─ Gideon";
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        System.out.println("I can protect me and you.");
    }

    @Override
    public void attack(List sideA, List sideB) {
        _TypeLine instance = (_TypeLine) sideB.get(0);
        instance.loseEnergy(super.getPower());
        super.gainEnergy(30);
        if (sideA.size() > 1) {
            instance = (_TypeLine) sideA.get(1);
            instance.gainEnergy(30);
            if (sideA.size() > 2) {
                instance = (_TypeLine) sideA.get(2);
                instance.gainEnergy(15);
            }
        }
    }
}
