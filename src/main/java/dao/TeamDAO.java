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
public class TeamDAO extends GenericDAO {

    @Override
    public String toString() {
        return "TeamDAO";
    }
    
    public static List<Team> findAll(int idPlayer) throws HibernateException {
        Session sessao = null;
        List p1 = null;

        try {
            sessao = ConnectionApp.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Team.class);

            // FROM
            Root tabela = consulta.from(Team.class);

            // RESTRIÇÕES
            Predicate restricoes = builder.equal(tabela.get("playerTeam"), idPlayer);

            consulta.where(restricoes);
            p1 = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
            System.out.println("TeamDAO close sessao");
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
