/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp;

import cdp.birthplace.BirthplaceTypes;
import cdp.birthplace.VrynType;
import cdp.birthplace.BithplaceSchema;
import cdp.birthplace.DefaultType;
import cdp.birthplace.KaladeshType;
import java.util.LinkedList;

/**
 *
 * @author almei
 */
public abstract class Planneswalker {

    final private String name;
    final private BithplaceSchema stratagyCalculus;
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
     * @param birth
     */
    public Planneswalker(int weight, int age, String name, BirthplaceTypes birth) {
        this.name = name;
        this.weight = weight;
        switch (birth) {
            case VRYN: {
                System.out.println("vryn");
                this.stratagyCalculus = new VrynType();
                this.maxEnergy = this.stratagyCalculus.caculateEnergy(this.age);
                break;
            }
            case KALADESH: {
                System.out.println("kaladesh");
                this.stratagyCalculus = new KaladeshType();
                this.maxEnergy = this.stratagyCalculus.caculateEnergy(this.weight);
                break;
            }
            default:
                this.stratagyCalculus = new DefaultType();
        }

        this.currentEnergy = this.maxEnergy;
        this.age = age;
        this.ready = 1;
    }
    
    public abstract void attack ( LinkedList sideA, LinkedList sideB);

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BithplaceSchema getStratagyCalculus() {
        return stratagyCalculus;
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
}
