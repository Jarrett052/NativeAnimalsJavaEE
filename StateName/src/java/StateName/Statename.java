/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateName;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author csz
 */
@Entity
@Table(name = "STATENAME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statename.findAll", query = "SELECT s FROM Statename s")
    , @NamedQuery(name = "Statename.findByStateid", query = "SELECT s FROM Statename s WHERE s.stateid = :stateid")
    , @NamedQuery(name = "Statename.findByStatename", query = "SELECT s FROM Statename s WHERE s.statename = :statename")})
public class Statename implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATEID")
    private Integer stateid;
    @Size(max = 150)
    @Column(name = "STATENAME")
    private String statename;

    public Statename() {
    }

    public Statename(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateid != null ? stateid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statename)) {
            return false;
        }
        Statename other = (Statename) object;
        if ((this.stateid == null && other.stateid != null) || (this.stateid != null && !this.stateid.equals(other.stateid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StateName.Statename[ stateid=" + stateid + " ]";
    }
    
}
