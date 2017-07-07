/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.dao;

import cl.patocueck.jdefragranking.model.Time;

/**
 *
 * @author pzunigap
 */
public interface TimeDao {

    public Time getTimeByEmail(String email);
    public void add(Time time);
    
    
}
