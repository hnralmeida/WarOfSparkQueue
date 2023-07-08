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
public class Jace extends _Base {
    
    public Jace(String name, int idCreature) {
        super(20, name, idCreature);
        this.type = "Planneswalker - Jace";
    }
    
    public Jace(String name, int idCreature, int energy) {
        super(20, name, idCreature);
        this.setMaxEnergy(1);
        this.setCurrentEnergy(1);
        this.type = "Creature Illusion";
    }
    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        System.out.println("Learn from errors from anothers...");
    }
    
    @Override
    public void attack(List sideA, List sideB) {
        _TypeLine instance = (_TypeLine) sideB.get(0);
        instance.loseEnergy(this.getPower());
        
        sideA.add(new Jace("Illusion", 0, 1));
        sideA.add(new Jace("Illusion", 0, 1));
    }
}
