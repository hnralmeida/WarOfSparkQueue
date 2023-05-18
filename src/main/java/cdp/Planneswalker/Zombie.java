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
public class Zombie extends Creature {

    public Zombie(int weight, int age, String name) {
        super(weight, age, name);
    }

    @Override
    public void attack(LinkedList sideA, LinkedList sideB) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
