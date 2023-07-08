/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp.CreatureInstance;

/**
 *
 * @author almei
 */
public class Zombie extends _Base {
    
    public Zombie(String name, int idCreature) {
        super(20, "Zombie", name, idCreature);
    }  

    public Zombie( String type, String name, int idCreature) {
        super(20, "Zombie " + type, name, idCreature);
    }  
    
}
