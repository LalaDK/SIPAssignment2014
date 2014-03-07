/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
 * @author Mads
 */
@Entity
@Table(name = "SUBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findBySId", query = "SELECT s FROM Subject s WHERE s.sId = :sId"),
    @NamedQuery(name = "Subject.findBySubjectname", query = "SELECT s FROM Subject s WHERE s.subjectname = :subjectname"),
    @NamedQuery(name = "Subject.findByPool", query = "SELECT s FROM Subject s WHERE s.pool = :pool")})
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "S_ID")
    private BigDecimal sId;
    @Size(max = 255)
    @Column(name = "SUBJECTNAME")
    private String subjectname;
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "POOL")
    private Character pool;
    @ManyToMany(mappedBy = "subjectCollection")
    private Collection<Person> personCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sId")
    private Collection<Round> roundCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private Collection<Vote> voteCollection;

    public Subject() {
    }

    public Subject(BigDecimal sId) {
        this.sId = sId;
    }

    public BigDecimal getSId() {
        return sId;
    }

    public void setSId(BigDecimal sId) {
        this.sId = sId;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getPool() {
        return pool;
    }

    public void setPool(Character pool) {
        this.pool = pool;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @XmlTransient
    public Collection<Round> getRoundCollection() {
        return roundCollection;
    }

    public void setRoundCollection(Collection<Round> roundCollection) {
        this.roundCollection = roundCollection;
    }

    @XmlTransient
    public Collection<Vote> getVoteCollection() {
        return voteCollection;
    }

    public void setVoteCollection(Collection<Vote> voteCollection) {
        this.voteCollection = voteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Subject[ sId=" + sId + " ]";
    }
    
}
