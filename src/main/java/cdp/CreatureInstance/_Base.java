/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp.CreatureInstance;

import cdp.Creature;
import java.util.List;

/**
 *
 * @author almei
 */
public abstract class _Base implements _TypeLine {

    private int idCreature;

    private String name;
    private int maxEnergy;
    protected int currentEnergy;
    private int power;
    protected String type;
    private int ready;

    @Override
    public String toString() {
        return name + "(" + currentEnergy + "/" + maxEnergy + ")\tTipo: " + type;
    }

    public _Base(int power, String name, int idCreature) {
        this.maxEnergy = 100;
        this.currentEnergy = 100;
        this.power = power;
        this.type = "Creature";
        this.name = name;
        this.idCreature = idCreature;
        this.ready = 1;
    }

    public _Base(int power, String type, String name, int idCreature) {
        this.maxEnergy = 100;
        this.currentEnergy = 100;
        this.power = power;
        this.type = "Creature - " + type;
        this.name = name;
        this.idCreature = idCreature;
        this.ready = 1;
    }

    public int getIdCreature() {
        return idCreature;
    }

    public void setIdCreature(int idCreature) {
        this.idCreature = idCreature;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        if (!(this.type.contains(type))) {
            this.type = this.type + " " + type;
        }
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    @Override
    public int getCurrentEnergy() {
        return currentEnergy;
    }

    @Override
    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    @Override
    public void loseEnergy(int energy) {
        int value = this.currentEnergy - energy;
        System.out.println(this.name + " perdeu " + energy + " (" + this.currentEnergy + " => " + value + ")");
        if (value > 0) {
            this.currentEnergy = value;
        } else {
            this.currentEnergy = 0;
        }
    }

    @Override
    public void gainEnergy(int energy) {
        int value = this.currentEnergy + energy;
        System.out.println(this.name + " ganhou " + energy + " (" + this.currentEnergy + " => " + value + ")");

        if (value < 100) {
            this.currentEnergy = value;
        } else {
            this.currentEnergy = 100;
        }
    }

    @Override
    public void attack(List sideA, List sideB) {
        _TypeLine instance = (_TypeLine) sideB.get(0);
        instance.loseEnergy(this.power);
    }

    @Override
    public int getReady() {
        return ready;
    }

    @Override
    public void setReady(int ready) {
        this.ready = ready;
    }

    @Override
    public void kills() {
        //add.add(new Creature(0, 0, name, idCreature, 0));
    }

}
