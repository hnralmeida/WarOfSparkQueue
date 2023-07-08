/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp.CreatureInstance;

/**
 *
 * @author almei
 */
public class Soldier extends _Base {

    public Soldier(String name, int idCreature) {
        super(20, name, idCreature);
        this.setType("Human Soldier");
    }
    
    public Soldier(int power, String type, String name, int idCreature) {
        super(power, type + " Soldier", name, idCreature);
    }   
    
}
