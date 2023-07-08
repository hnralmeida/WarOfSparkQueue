/*
 * Projeto de Programação Orientada a Objetos
 * AUTOR: Henrique Almeida de Oliveira
 */
package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author almei
 */
public class GenericDAO {

    public void inserir(Object obj) throws HibernateException {
        Session sessao = null;
        try {
            sessao = ConnectionApp.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(obj);

            sessao.getTransaction().commit();
            sessao.close();
            System.out.println("GenericDao close sessao");
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }

    }

    public void alterar(Object obj) throws HibernateException {
        Session sessao = null;
        try {
            sessao = ConnectionApp.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.update(obj);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }

    }

    public void excluir(Object obj) throws HibernateException {
        Session sessao = null;
        try {
            sessao = ConnectionApp.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.delete(obj);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
    }

    public List listar(Class classe) throws HibernateException {
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConnectionApp.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaQuery consulta = sessao.getCriteriaBuilder().createQuery(classe);
            consulta.from(classe);
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }
}
