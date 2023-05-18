/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp.Planneswalker;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author almei
 */
@Entity
public abstract class Creature {

    @Id
    private int id;
    
    final private String name;
    private int weight;
    private int maxEnergy;
    protected int currentEnergy;
    private int age;
    private int ready;

    /**
     * Um guerreiro pronto para batalha é criado com os parametros passados e
     * com energia base 100
     *
     * @param weight peso
     * @param age idade
     * @param name nome
     */
    public Creature(int weight, int age, String name) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.ready = 1;
        this.maxEnergy = 100;
        this.currentEnergy = this.maxEnergy;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getReady() {
        return ready;
    }

    public void setReady(int ready) {
        this.ready = ready;
    }

    public abstract void attack(LinkedList sideA, LinkedList sideB);

}
