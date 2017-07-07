package cl.patocueck.jdefragranking.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cl.patocueck.jdefragranking.dao.PlayerDao;
import cl.patocueck.jdefragranking.model.Player;

@Repository
@Transactional
public class PlayerDaoImp implements PlayerDao {

    @PersistenceContext
    EntityManager em;
	
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Player> getAll() {
        return  em.createNamedQuery("Player.findAll").getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Player getById(String email) {
        return em.find(Player.class, email);
    }

    @Override
    public void add(Player player) {
        em.persist(player);	
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean update(Player player) {
        try{
            em.merge(player);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
