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
public class Liliana extends _Base{
    public Liliana(String name, int idCreature) {
        super(40, name, idCreature);
        this.type = "Planneswalker - Liliana";
    }
    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        System.out.println("you can't beat me...");
    }
    
    @Override
    public void kills( ){
        this.gainEnergy(50);
    }
}
