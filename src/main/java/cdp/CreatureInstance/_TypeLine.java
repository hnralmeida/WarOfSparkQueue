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
public interface _TypeLine {

    public abstract void attack(List sideA, List sideB);
    
    public String getType();
    
    public void setType(String type);

    public int getMaxEnergy();

    public void setMaxEnergy(int maxEnergy);

    public void setCurrentEnergy(int currentEnergy);
    
    public int getCurrentEnergy();
    
    public void loseEnergy(int currentEnergy);
    
    public void gainEnergy(int currentEnergy);
    
    public int getPower();

    public void setPower(int power);
    
    public int getReady();

    public void setReady(int ready);
    
    public void kills();
    
    public String getName();

    public void setName(String name);
    
}
