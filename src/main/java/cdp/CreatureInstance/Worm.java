/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp.CreatureInstance;

/**
 *
 * @author almei
 */
public class Worm extends _Base {

    public Worm(String name, int idCreature) {
        super(60, "Worm", name, idCreature);
        this.setMaxEnergy(200);
        this.setCurrentEnergy(200);
    }

}
