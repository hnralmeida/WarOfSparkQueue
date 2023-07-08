/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp;

import java.io.Serializable;
//import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author almei
 */
@Entity
public class Player implements Serializable {

    @Override
    public String toString() {
        return "Jogador: " + "name=" + name + " (id=" + idPlayer + ")";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlayer;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private int currency;
    
    //@Temporal ( TemporalType.DATE )
    @Column(nullable = false)
    private String dtNasc;

    @Column(nullable = false)
    private String email;

    @Lob
    private byte[] pic;

    // Relations
    @OneToMany(mappedBy = "playerTeam", fetch = FetchType.LAZY)
    @Column(nullable = true)
    private List<Team> team;
    
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    @Column(nullable = true)
    private List<Match> matches;

    public Player() {
    }

    public Player(String name, String email, String dtNasc, String token, int currency, byte[] pic) {
        this.name = name;
        this.dtNasc = dtNasc;
        this.email = email;
        this.token = token;
        this.currency = currency;
        this.pic = pic;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }
    
    public int getId() {
        return idPlayer;
    }

    public void setId(int id) {
        this.idPlayer = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
    
    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

}
