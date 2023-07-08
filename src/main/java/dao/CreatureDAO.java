/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package dao;

import cdp.*;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author almei
 */
public class CreatureDAO extends GenericDAO {

    @Override
    public String toString() {
        return "CreatureDAO";
    }

    /**
     *
     * @param idCreature
     * @return
     * @throws HibernateException
     */
    public static List<Creature> find(int idCreature) throws HibernateException {
        Session sessao = null;
        List p1 = null;

        try {
            sessao = ConnectionApp.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Creature.class);

            // FROM
            Root tabela = consulta.from(Creature.class);

            // RESTRIÇÕES
            Predicate restricoes = builder.equal(tabela.get("id"), idCreature);

            consulta.where(restricoes);
            p1 = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
            System.out.println("CreatureDAO close sessao");
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        if (!p1.isEmpty()) {
            return p1;
        } else {
            return null;
        }
    }

    /**
     *
     * @return @throws HibernateException
     */
    public static List<Creature> findAll() throws HibernateException {
        Session sessao = null;
        List p1 = null;

        try {
            sessao = ConnectionApp.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Creature.class);

            // FROM
            Root tabela = consulta.from(Creature.class);
            /*
            // RESTRIÇÕES
            Predicate restricoes = builder.equal(tabela.get("idPlayer"), idPlayer);

            consulta.where(restricoes);
            */
            p1 = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
            System.out.println("CampaignDAO close sessao");
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        if (!p1.isEmpty()) {
            return p1;
        } else {
            return null;
        }
    }
    
    /**
     * Remove uma criatura do time
     * 
     * @param creature
     * @throws HibernateException
     */
    public static void remove(Creature creature) throws HibernateException {
        
    }
}
