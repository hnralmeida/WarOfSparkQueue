/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author almei
 */
@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTeam;
    
    // Relations
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPlayer")
    private Player playerTeam;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Creature> teamA = new ArrayList();
    

    public Team() {
    }
    
    /**
     * inicializa o time do jogador
     *
     * @param timeA O nome do primeiro arquivo a ser lido
     * @param player
     */
    public Team(List<Creature> timeA, Player player) {
        teamA = new ArrayList(timeA);
        this.playerTeam = player;
    }

    /**
     * retorna um guerreiro na posição i no paremetro no timeA
     *
     * @return a lista de guerreiro, se a posição for válida para o timeA
     */
    public List<Creature> getTeamA() {
        return (List) this.teamA;
    }
    
    public void setTeamA(ArrayList<Creature> list) {
        this.teamA = list;
    }

  
}
