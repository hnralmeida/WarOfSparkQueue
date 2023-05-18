/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package dao;

import cdp.Planneswalker.Creature;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author almei
 */
public class CreatureDAO {
    public EntityManager getEM () {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.ravos_WarOfSpark");
        return factory.createEntityManager();
    }
    
    public Creature salvar (Creature creature) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(creature);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
        return creature;
    }
}
