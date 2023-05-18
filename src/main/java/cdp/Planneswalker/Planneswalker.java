/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp.Planneswalker;

/**
 *
 * @author almei
 */
public abstract class Planneswalker extends Creature {

    public Planneswalker(int weight, int age, String name) {
        super(weight, age, name);
    }

    public abstract Creature getInstance();

}
