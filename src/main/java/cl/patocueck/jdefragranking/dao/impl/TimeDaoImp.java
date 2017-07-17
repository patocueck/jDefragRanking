/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.dao.impl;

import cl.patocueck.jdefragranking.dao.TimeDao;
import cl.patocueck.jdefragranking.model.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pzunigap
 */
@Repository
@Transactional
public class TimeDaoImp implements TimeDao {

    @PersistenceContext
    EntityManager em;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Time getTimeByEmail(String email, String map, String physic) {
        try{
            return (Time) em
            .createQuery("SELECT t FROM Time t WHERE t.email = :email and t.map = :map and t.physic = :physic")
            .setParameter("email", email)
            .setParameter("map", map)
            .setParameter("physic", physic)
            .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(Time time) {
        em.persist(time);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Time> getTop(String map, String physic) {
        return em.createQuery("SELECT t FROM Time t WHERE t.map = :map and t.physic = :physic order by time ASC")
        .setParameter("map", map)
        .setParameter("physic", physic)
        .setMaxResults(10)
        .getResultList();
    }
    
}
