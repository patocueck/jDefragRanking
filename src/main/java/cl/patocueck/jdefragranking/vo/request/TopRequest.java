/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.vo.request;

/**
 *
 * @author pzunigap
 */
public class TopRequest {
    
    String map;
    String physic;

    public boolean isNotValid(){
        if (map == null) return true;
        if (physic == null) return true;
        if (map.equals("")) return true;
        if (physic.equals("")) return true;
        return false;
    }
    
    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getPhysic() {
        return physic;
    }

    public void setPhysic(String physic) {
        this.physic = physic;
    }
}
