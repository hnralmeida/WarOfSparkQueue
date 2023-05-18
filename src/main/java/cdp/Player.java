/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package cdp;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author almei
 */
@Entity
public class Player {
    
    @Id
    private int id;
    
    private String name;
    private String token;
    private int currency;
    private byte[] pic;

    public Player(String name, String token, int currency, byte[] pic) {
        this.name = name;
        this.token = token;
        this.currency = currency;
        this.pic = pic;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        
}
