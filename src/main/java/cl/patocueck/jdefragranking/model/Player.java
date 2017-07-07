/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pzunigap
 */
@Entity
@Table(name = "PLAYER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")
    , @NamedQuery(name = "Player.findByEmail", query = "SELECT p FROM Player p WHERE p.email = :email")
    , @NamedQuery(name = "Player.findByNombre", query = "SELECT p FROM Player p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Player.findByNick", query = "SELECT p FROM Player p WHERE p.nick = :nick")
    , @NamedQuery(name = "Player.findByNickNoColor", query = "SELECT p FROM Player p WHERE p.nickNoColor = :nickNoColor")
    , @NamedQuery(name = "Player.findByApellidos", query = "SELECT p FROM Player p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Player.findByPassword", query = "SELECT p FROM Player p WHERE p.password = :password")})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "NICK")
    private String nick;
    @Basic(optional = false)
    @Column(name = "NICK_NO_COLOR")
    private String nickNoColor;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;

    public Player() {
    }

    public Player(String email) {
        this.email = email;
    }

    public Player(String email, String nombre, String nick, String nickNoColor, String apellidos, String password) {
        this.email = email;
        this.nombre = nombre;
        this.nick = nick;
        this.nickNoColor = nickNoColor;
        this.apellidos = apellidos;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
        String nickTemp = "";
        nickTemp = nickTemp.replaceAll("^1", "");
        nickTemp = nickTemp.replaceAll("^2", "");
        nickTemp = nickTemp.replaceAll("^3", "");
        nickTemp = nickTemp.replaceAll("^4", "");
        nickTemp = nickTemp.replaceAll("^5", "");
        nickTemp = nickTemp.replaceAll("^6", "");
        nickTemp = nickTemp.replaceAll("^7", "");
        nickTemp = nickTemp.replaceAll("^8", "");
        nickTemp = nickTemp.replaceAll("^9", "");
        nickTemp = nickTemp.replaceAll("^0", "");
        this.nickNoColor = nickTemp;
    }

    public String getNickNoColor() {
        return nickNoColor;
    }

    public void setNickNoColor(String nickNoColor) {
        this.nickNoColor = nickNoColor;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.patocueck.jdefragranking.model.Player[ email=" + email + " ]";
    }
    
}
