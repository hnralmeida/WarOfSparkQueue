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
public class CampaignDAO extends GenericDAO {

    @Override
    public String toString() {
        return "CampaignDAO";
    }

    public static List<CampaignMatch> findAll(int idPlayer) throws HibernateException {
        Session sessao = null;
        List p1 = null;

        try {
            sessao = ConnectionApp.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(CampaignMatch.class);

            // FROM
            Root tabela = consulta.from(CampaignMatch.class);

            /*/ RESTRIÇÕES
            Predicate restricoes = builder.equal(tabela.get("idPlayer"), idPlayer);

            consulta.where(restricoes);*/
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
    
    
    public static List<CampaignMatch> findAll() throws HibernateException {
        Session sessao = null;
        List p1 = null;

        try {
            sessao = ConnectionApp.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(CampaignMatch.class);

            // FROM
            Root tabela = consulta.from(CampaignMatch.class);

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

}
