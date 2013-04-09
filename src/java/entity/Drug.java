/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anton
 */
@Entity
@Table(name = "drug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drug.findAll", query = "SELECT d FROM Drug d"),
    @NamedQuery(name = "Drug.findById", query = "SELECT d FROM Drug d WHERE d.id = :id")})
public class Drug implements Serializable {
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
    @Column(name = "form")
    private String form;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "serial")
    private String serial;
    @JoinColumn(name = "realise_name", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RealiseName realiseName;
    @JoinColumn(name = "indications_for_use", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private IndicationsForUse indicationsForUse;
    @JoinColumn(name = "active_component", referencedColumnName = "idcomponent")
    @ManyToOne(optional = false)
    private Component activeComponent;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company company;

    public Drug() {
    }

    public Drug(Integer id) {
        this.id = id;
    }

    public Drug(Integer id, String form, String serial) {
        this.id = id;
        this.form = form;
        this.serial = serial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public RealiseName getRealiseName() {
        return realiseName;
    }

    public void setRealiseName(RealiseName realiseName) {
        this.realiseName = realiseName;
    }

    public IndicationsForUse getIndicationsForUse() {
        return indicationsForUse;
    }

    public void setIndicationsForUse(IndicationsForUse indicationsForUse) {
        this.indicationsForUse = indicationsForUse;
    }

    public Component getActiveComponent() {
        return activeComponent;
    }

    public void setActiveComponent(Component activeComponent) {
        this.activeComponent = activeComponent;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        if (!(object instanceof Drug)) {
            return false;
        }
        Drug other = (Drug) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Drug[ id=" + id + " ]";
    }
    
}
