package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class VotePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "P_ID")
    private BigInteger pId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "R_ID")
    private BigInteger rId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "S_ID")
    private BigInteger sId;

    public VotePK() {
    }

    public VotePK(BigInteger pId, BigInteger rId, BigInteger sId) {
        this.pId = pId;
        this.rId = rId;
        this.sId = sId;
    }

    public BigInteger getPId() {
        return pId;
    }

    public void setPId(BigInteger pId) {
        this.pId = pId;
    }

    public BigInteger getRId() {
        return rId;
    }

    public void setRId(BigInteger rId) {
        this.rId = rId;
    }

    public BigInteger getSId() {
        return sId;
    }

    public void setSId(BigInteger sId) {
        this.sId = sId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        hash += (rId != null ? rId.hashCode() : 0);
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotePK)) {
            return false;
        }
        VotePK other = (VotePK) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VotePK[ pId=" + pId + ", rId=" + rId + ", sId=" + sId + " ]";
    }
    
}
