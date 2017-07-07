package cl.patocueck.jdefragranking.dao;

import cl.patocueck.jdefragranking.model.Player;
import java.util.List;


public interface PlayerDao {

    public List<Player> getAll();
    public Player getById(String email);
    public void add(Player player);
    public boolean update(Player player);
}
