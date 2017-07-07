/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.patocueck.jdefragranking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pzunigap
 */
@Entity
@Table(name = "TIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t")
    , @NamedQuery(name = "Time.findById", query = "SELECT t FROM Time t WHERE t.id = :id")
    , @NamedQuery(name = "Time.findByEmail", query = "SELECT t FROM Time t WHERE t.email = :email")
    , @NamedQuery(name = "Time.findByMap", query = "SELECT t FROM Time t WHERE t.map = :map")
    , @NamedQuery(name = "Time.findByTime", query = "SELECT t FROM Time t WHERE t.time = :time")
    , @NamedQuery(name = "Time.findByPhysic", query = "SELECT t FROM Time t WHERE t.physic = :physic")})
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "MAP")
    private String map;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @Column(name = "PHYSIC")
    private String physic;

    public Time() {
    }

    public Time(BigDecimal id) {
        this.id = id;
    }

    public Time(BigDecimal id, String email, String map, String physic) {
        this.id = id;
        this.email = email;
        this.map = map;
        this.physic = physic;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPhysic() {
        return physic;
    }

    public void setPhysic(String physic) {
        this.physic = physic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Time)) {
            return false;
        }
        Time other = (Time) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.patocueck.jdefragranking.model.Time[ id=" + id + " ]";
    }
    
}
