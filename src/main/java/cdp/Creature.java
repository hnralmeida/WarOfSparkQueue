/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp;

import cdp.CreatureInstance.*;
import java.io.Serializable;
import java.text.ParseException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import cdp.CreatureInstance._TypeLine;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author almei
 */
@Entity
@Table(name = "Creature")
public class Creature implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCreature;

    @Column(nullable = false)
    private int idInterface;

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    
    @ManyToMany(mappedBy = "teamA", fetch = FetchType.LAZY)
    private List<Match> matchTA;

    @ManyToMany(mappedBy = "teamB", fetch = FetchType.LAZY)
    private List<Match> matchTB;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTeam")
    private Team team;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCampaign")
    private CampaignMatch campaignMatches;

    private int ready;

    /**
     * Essa parte dos atributos são geradas no construtor para o app
     *
     * @return
     */
    public _TypeLine Instance() {
        switch (idInterface) {
            case 1:
                return new Soldier(this.name, this.idCreature);
            case 2:
                return new Zombie(this.name, this.idCreature);
            case 3:
                return new ZombieWarrior(this.name, this.idCreature);
            case 4:
                return new Worm(this.name, this.idCreature);
            case 5:
                return new Jace(this.name, this.idCreature);
            case 6:
                return new Jace(this.name, this.idCreature, 1);
            case 7:
                return new Liliana(this.name, this.idCreature);
            case 8:
                return new Gideon(this.name, this.idCreature);
            default:
                System.out.println("Erro ao criar Criatura " + idInterface);
                return null;
        }
    }

    ;

    /**
     *
     * @return
     */
    public int getIdInterface() {
        return idInterface;
    }

    /**
     *
     * @param idInterface
     */
    public void setIdInterface(int idInterface) {
        this.idInterface = idInterface;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Relations
    public Creature() {

    }

    /**
     * Um guerreiro pronto para batalha é criado com os parametros passados e
     * com energia base 100
     *
     * @param weight
     * @param age
     * @param name
     * @param idInterface
     * @param price
     */
    public Creature(int weight, int age, String name, int idInterface, int price) {
        this.weight = weight;
        this.age = age;
        this.name = name;
        this.ready = 1;
        this.idInterface = idInterface;
        this.price = price;
    }

    /**
     * Um guerreiro pronto para batalha é criado com os parametros passados e
     * com energia base 100
     *
     * @param weight peso
     * @param age idade
     * @param name
     * @param idInterface
     * @param price
     * @param campaignMatch
     */
    public Creature(int weight, int age, String name, int idInterface, int price, CampaignMatch campaignMatch) {
        this.weight = weight;
        this.age = age;
        this.name = name;
        this.ready = 1;
        this.idInterface = idInterface;
        this.price = price;
        this.campaignMatches = campaignMatch;
    }

    /**
     * Um guerreiro pronto para batalha é criado com os parametros passados e
     * com energia base 100
     *
     * @param weight peso
     * @param age idade
     * @param name
     * @param idInterface
     * @param price
     * @param team
     */
    public Creature(int weight, int age, String name, int idInterface, int price, Team team) {
        this.weight = weight;
        this.age = age;
        this.name = name;
        this.ready = 1;
        this.idInterface = idInterface;
        this.price = price;
        this.team = team;
    }

    public List<Match> getMatchTA() {
        return matchTA;
    }

    public void setMatchTA(List<Match> match) {
        this.matchTA = match;
    }

    public List<Match> getMatchTB() {
        return matchTB;
    }

    public void setMatchTB(List<Match> match) {
        this.matchTB = match;
    }

    public int getIdCreature() {
        return idCreature;
    }

    public void setIdCreature(int idCreature) {
        this.idCreature = idCreature;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Object[] toArray() throws ParseException {
        return new Object[]{name, weight, age, this.Instance().getType()};
    }

    @Override
    public String toString() {
        return "Creature{" + "name=" + name + ", type=" + this.Instance().getType() + '}';
    }

}
