/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp.Planneswalker;

import java.util.LinkedList;

/**
 *
 * @author almei
 */
public class Nissa extends Planneswalker{
    
    Nissa instance;

    /**
     *
     * @param weight
     * @param age
     * @param name
     */
    public Nissa(int weight, int age, String name) {
        super(weight, age, name);
    }

    /**
     *
     * @return Liliana
     */
    @Override
    public Creature getInstance() {
        return instance;
    }

    /**
     *
     * @param sideA
     * @param sideB
     */
    @Override
    public void attack(LinkedList sideA, LinkedList sideB) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
