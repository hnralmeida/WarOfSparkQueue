/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp;

import cdp.Planneswalker.Creature;
import java.util.LinkedList;

/**
 *
 * @author almei
 */
public class CampaignMatch {
    private final String name;
    private final int position;
    private final LinkedList<Creature> team;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public LinkedList<Creature> getTeam() {
        return team;
    }

    public CampaignMatch(String name, int position, LinkedList<Creature> team) {
        this.name = name;
        this.position = position;
        this.team = team;
    }
    
}
