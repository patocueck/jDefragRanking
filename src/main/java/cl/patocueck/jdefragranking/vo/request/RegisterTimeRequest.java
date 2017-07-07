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
    
    private String nick;
    private String map;
    private String physic;

    public boolean isNotValid(){
        if (nick == null) return true;
        if (map == null) return true;
        if (physic == null) return true;
        if (nick.equals("")) return true;
        if (map.equals("")) return true;
        if (physic.equals("")) return true;

        return false;
    }
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
