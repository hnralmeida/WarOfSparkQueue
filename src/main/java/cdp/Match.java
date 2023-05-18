/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp;

import cdp.Planneswalker.Creature;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author almei
 */
public class Match {

    private final LinkedList<Creature> teamA;
    private final LinkedList<Creature> teamB;
    private final LinkedList<Creature> deadB;
    private final LinkedList<Creature> deadA;

    /**
     * inicializa os 2 times de uma partida a partir de arquivos
     *
     * @param timeA O nome do primeiro arquivo a ser lido
     * @param timeB O nome do segundo arquivo a ser lido
     * @throws java.io.IOException tratamento da exceção
     */
    public Match(LinkedList<Creature> timeA, LinkedList<Creature> timeB) throws IOException {
        teamA = new LinkedList(timeA);
        teamB = new LinkedList(timeB);
        deadA = new LinkedList();
        deadB = new LinkedList();
    }

    /**
     *
     * @return
     */
    public LinkedList<Creature> getDeadB() {
        return deadB;
    }

    /**
     *
     * @return
     */
    public LinkedList<Creature> getDeadA() {
        return deadA;
    }

    /**
     * retorna um guerreiro na posição i no paremetro no timeA
     *
     * @return a lista de guerreiro, se a posição for válida para o timeA
     */
    public LinkedList getTeamA() {
        return (LinkedList) this.teamA;
    }

    /**
     * retorna um guerreiro na posição i no paremetro no timeB
     *
     * @return O guerreiro procurado, se a posição for válida para o timeB
     */
    public LinkedList getTeamB() {
        return (LinkedList) this.teamB;
    }

}
