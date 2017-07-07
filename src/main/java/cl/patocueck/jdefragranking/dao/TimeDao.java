/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.dao;

import cl.patocueck.jdefragranking.model.Time;
import java.util.List;

/**
 *
 * @author pzunigap
 */
public interface TimeDao {

    public Time getTimeByEmail(String email, String map, String physic);
    public void add(Time time);
    public List<Time> getTop(String map, String physic);
    
    
}
