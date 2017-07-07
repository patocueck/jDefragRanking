/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.vo.request;

/**
 *
 * @author pato
 */
public class RegisterTimeRequest {
    
    private String email;
    private String map;
    private String physic;
    private String time;

    public boolean isNotValid(){
        if (email == null) return true;
        if (map == null) return true;
        if (physic == null) return true;
        if (time == null) return true;
        
        if (email.equals("")) return true;
        if (map.equals("")) return true;
        if (physic.equals("")) return true;
        if (time.equals("")) return true;

        return false;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
