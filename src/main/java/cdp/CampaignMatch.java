/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author almei
 */
@Entity
public class CampaignMatch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCampaign;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int position;

    @OneToMany(mappedBy = "campaignMatches", fetch = FetchType.EAGER)
    @Column(nullable = true)
    private List<Creature> creatureList;

    public CampaignMatch() {

    }

    /**
     * @Brief recebe uma lista com as criaturas da partida, nome e um jogador que não vai ser usado na função.
     * 
     * @param Creatures
     * @param name
     * @param position
     * @param player 
     */
    public CampaignMatch(List Creatures, String name, int position, Player player) {
        System.out.println("\n\n=======" + "\nTamanho: " + Creatures.size() + "\n\n=======");
        this.creatureList = Creatures;
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public List<Creature> getTeam() {
        return creatureList;
    }

    public int getIdMatch() {
        return idCampaign;
    }

    public void addCreature(Creature c) {
        creatureList.add(c);
    }

    public void setIdMatch(int idMatch) {
        this.idCampaign = idMatch;
    }

    public Object[] toArray() throws ParseException {
        return new Object[]{position, name, creatureList.size()};
    }

    @Override
    public String toString() {
        return "idCampaign=" + idCampaign + ", name=" + name;
    }

    
}
