/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.Msg;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Robson
 * @param <T>
 * @param <ID>
 */
public abstract class GenericDao<T, ID> {

    public static EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dormitorio");
        return factory.createEntityManager();
    }

    Msg msg = new Msg();

    public T salvar2(T entity) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
         //   msg.addSuccessMessage("Registro salvo com sucesso !");
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return entity;
    }

    public T buscarPorId(Class<T> clazz, ID id) {
        EntityManager em = getEM();
        T t = null;
        try {
            em.getTransaction().begin();
            t = em.find(clazz, id);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return t;
    }

    public void remover(Class<T> clazz, ID id) {
        EntityManager em = getEM();
        T t = em.find(clazz, id);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
            msg.addSuccessMessage("Registro excluído com sucesso !");
        } catch (Exception e) {
            msg.addErrorMessage("O registro não pode ser excluído !");

        } finally {
            em.close();
        }

    }

    public T atualizar(T entity) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (!estaVinculado(entity)) {
                entity = em.merge(entity);
            }
            em.getTransaction().commit();
            //msg.addSuccessMessage("Registro atualizado com sucesso !");
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return entity;
    }

    public boolean estaVinculado(T entity) {
        EntityManager em = getEM();
        return em.contains(entity);
    }

    public List<T> listarTodos(Class<T> clazz) {
        EntityManager em = getEM();
        List<T> listar = null;
        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> criteria = cb.createQuery(clazz);
            criteria.from(clazz);
            listar = em.createQuery(criteria).getResultList();
       
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return listar;
    }

    public List<T> listarRelacoes(Class<T> clazz, List<String> params) {
        List<T> listar = null;
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = builder.createQuery(clazz);

            Root<T> pesquisa = criteriaQuery.from(clazz);
            for (int i = 0; i < params.size(); i++) {
                pesquisa.fetch(params.get(i));
            }
            criteriaQuery.select(pesquisa);

            TypedQuery<T> query = em.createQuery(criteriaQuery);
            listar = query.getResultList();
       
        } catch (Exception e) {

        } finally {
            em.close();
        }
        return listar;
    }

}
