/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package dao;

import cdp.Player;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author almei
 */
public class PlayerDAO {
    public EntityManager getEM () {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.ravos_WarOfSpark");
        return factory.createEntityManager();
    }
    
    public Player salvar (Player player) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
        return player;
    }
}
