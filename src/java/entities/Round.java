package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mads
 */
@Entity
@Table(name = "ROUND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Round.findAll", query = "SELECT r FROM Round r"),
    @NamedQuery(name = "Round.findByRId", query = "SELECT r FROM Round r WHERE r.rId = :rId"),
    @NamedQuery(name = "Round.findByRoundno", query = "SELECT r FROM Round r WHERE r.roundno = :roundno"),
    @NamedQuery(name = "Round.findByIspublic", query = "SELECT r FROM Round r WHERE r.ispublic = :ispublic")})
public class Round implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "R_ID")
    private BigDecimal rId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROUNDNO")
    private BigInteger roundno;
    @Column(name = "ISPUBLIC")
    private Character ispublic;
    @JoinColumn(name = "S_ID", referencedColumnName = "S_ID")
    @ManyToOne(optional = false)
    private Subject sId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "round")
    private Collection<Vote> voteCollection;

    public Round() {
    }

    public Round(BigDecimal rId) {
        this.rId = rId;
    }

    public Round(BigDecimal rId, BigInteger roundno) {
        this.rId = rId;
        this.roundno = roundno;
    }

    public BigDecimal getRId() {
        return rId;
    }

    public void setRId(BigDecimal rId) {
        this.rId = rId;
    }

    public BigInteger getRoundno() {
        return roundno;
    }

    public void setRoundno(BigInteger roundno) {
        this.roundno = roundno;
    }

    public Character getIspublic() {
        return ispublic;
    }

    public void setIspublic(Character ispublic) {
        this.ispublic = ispublic;
    }

    public Subject getSId() {
        return sId;
    }

    public void setSId(Subject sId) {
        this.sId = sId;
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
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Round)) {
            return false;
        }
        Round other = (Round) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Round[ rId=" + rId + " ]";
    }
    
}
