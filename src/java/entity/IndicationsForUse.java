/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anton
 */
@Entity
@Table(name = "indications_for_use")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndicationsForUse.findAll", query = "SELECT i FROM IndicationsForUse i"),
    @NamedQuery(name = "IndicationsForUse.findById", query = "SELECT i FROM IndicationsForUse i WHERE i.id = :id")})
public class IndicationsForUse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "indications_for_use")
    private String indicationsForUse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicationsForUse")
    private List<Drug> drugList;

    public IndicationsForUse() {
    }

    public IndicationsForUse(Integer id) {
        this.id = id;
    }

    public IndicationsForUse(Integer id, String indicationsForUse) {
        this.id = id;
        this.indicationsForUse = indicationsForUse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndicationsForUse() {
        return indicationsForUse;
    }

    public void setIndicationsForUse(String indicationsForUse) {
        this.indicationsForUse = indicationsForUse;
    }

    @XmlTransient
    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
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
        if (!(object instanceof IndicationsForUse)) {
            return false;
        }
        IndicationsForUse other = (IndicationsForUse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.IndicationsForUse[ id=" + id + " ]";
    }
    
}
