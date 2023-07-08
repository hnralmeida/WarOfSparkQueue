/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp;

import cdp.CreatureInstance._TypeLine;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author almei
 */
@Entity
@Table(name = "Match")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatch;

    @Temporal(TemporalType.DATE)
    private Date dateEvent;

    @Column(nullable = false)
    private boolean victory;

    @Column(nullable = false, columnDefinition="text")
    private String log="";

    // Relations
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPlayer")
    private Player player;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Creature_MatchTA",
            joinColumns = {
                @JoinColumn(name = "idMatchTA")},
            inverseJoinColumns = {
                @JoinColumn(name = "idCreatureTA")}
    )
    private List<Creature> teamA;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Creature_MatchTB",
            joinColumns = {
                @JoinColumn(name = "idMatchTB")},
            inverseJoinColumns = {
                @JoinColumn(name = "idCreatureTB")}
    )
    private List<Creature> teamB;

    public Match() {
    }

    /**
     * inicializa os 2 times de uma partida a partir de parâmetros
     *
     * @param timeA O nome do primeiro arquivo a ser lido
     * @param timeB O nome do segundo arquivo a ser lido
     */
    public Match(LinkedList<Creature> timeA, LinkedList<Creature> timeB) {
        teamA = new LinkedList(timeA);
        teamB = new LinkedList(timeB);
    }

    /**
     * inicializa os 2 times de uma partida a partir de parâmetros
     *
     * @param timeA O nome do primeiro arquivo a ser lido
     * @param timeB O nome do segundo arquivo a ser lido
     * @param date Data da partida
     * @param player Jogador logado
     */
    public Match(List<Creature> timeA, List<Creature> timeB, Date date, Player player) {
        teamA = new LinkedList(timeA);
        teamB = new LinkedList(timeB);
        this.dateEvent = date;
        this.player = player;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
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

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    /**
     * @brief percorre ambas filas de guerreiros verificando se há guerreiros
     * mortos e faz com que o primeiro da fila inimiga elimine
     * (warrior.killWarrior) um guerreiro com energia<0
     */
    private void check(LinkedList<_TypeLine> hero, LinkedList<_TypeLine> enemy) {
        // Separa os atacantes de cada fila
        // Verifica se há na fila A mortos, remove eles e os coloca na primeira 
        // posição para ser devidamente eliminados 
        if (!hero.isEmpty()) {
            for (int i = 0; i < hero.size(); i++) {
                if (hero.get(i).getCurrentEnergy() < 1) {
                    enemy.get(i).kills();
                    log = log + enemy.get(i).getName() + " kills " + hero.get(i).getName() + "\n";
                    hero.remove(i);
                    i = -1;
                }
            }
        }

        // Verifica se há na fila B mortos, remove eles e os coloca na primeira 
        // posição para ser devidamente eliminados 
        if (!enemy.isEmpty()) {
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).getCurrentEnergy() < 1) {
                    hero.get(i).kills();
                    log = log + hero.get(i).getName() + " kills " + enemy.get(i).getName() + "\n";
                    enemy.remove(i);
                    i = -1;
                }
            }
        }
    }

    public int calculate() {
        LinkedList<_TypeLine> hero = new LinkedList<>();
        LinkedList<_TypeLine> enemy = new LinkedList<>();

        for (Creature c : this.teamA) {
            hero.add(c.Instance());
        }
        for (Creature c : this.teamB) {
            enemy.add(c.Instance());
        }

        do {
            _TypeLine c1 = hero.get(0);
            _TypeLine c2 = enemy.get(0);
            c1.setReady(1);
            c2.setReady(1);

            // Escolhe quem vai atacar primeiro e realiza os ataques da rodada
            int random = (int) (10 * Math.random());
            if (random % 2 == 1) {
                log = log + c1.getName() + " attacks " + c2.getName() + "\n";
                if (c1.getReady() == 1) {
                    c1.attack(hero, enemy);
                }
                log = log + c2.getName() + " attacks " + c1.getName() + "\n";
                if (c2.getReady() == 1 && c2.getCurrentEnergy() > 0) {
                    c2.attack(enemy, hero);
                }
            } else {
                log = log + c2.getName() + " attacks " + c1.getName() + "\n";
                if (c2.getReady() == 1) {
                    c2.attack(enemy, hero);
                }
                log = log + c1.getName() + " attacks " + c2.getName() + "\n";
                if (c1.getReady() == 1 && c1.getCurrentEnergy() > 0) {
                    c1.attack(hero, enemy);
                }
            }
            this.check(hero, enemy);

            // Verifica a quantidade de Guerreiro e passa o primeiro para o ultimo
            // Acontece só se tiver ao menos 1 guerreiro
            if (!hero.isEmpty()) {
                hero.addLast(hero.removeFirst());
            }
            if (!enemy.isEmpty()) {
                enemy.addLast(enemy.removeFirst());
            }
            // Se alguma fila estiver com 0 Warrior, termina o programa
        } while (!hero.isEmpty() && !enemy.isEmpty());

        if (!hero.isEmpty()) {
            System.out.println("Heróis venceram: ");
            log = log + "\n\tHeróis venceram!" + "\n";
            this.victory = true;
            for (_TypeLine aux : hero) {
                System.out.println("\t" + aux);
                log = log + "\t\t" + aux + "\n";
            }
            return 10;
        } else {
            System.out.println("Inimigos venceram: ");
            log = log + "\n\tInimigos venceram!" + "\n";
            this.victory = false;
            for (_TypeLine aux : enemy) {
                System.out.println("\t" + aux);
                log = log + "\t\t" + aux + "\n";
            }
            return 0;
        }
    }
}
