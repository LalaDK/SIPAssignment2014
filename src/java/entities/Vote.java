/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mads
 */
@Entity
@Table(name = "VOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v"),
    @NamedQuery(name = "Vote.findByPId", query = "SELECT v FROM Vote v WHERE v.votePK.pId = :pId"),
    @NamedQuery(name = "Vote.findByRId", query = "SELECT v FROM Vote v WHERE v.votePK.rId = :rId"),
    @NamedQuery(name = "Vote.findBySId", query = "SELECT v FROM Vote v WHERE v.votePK.sId = :sId"),
    @NamedQuery(name = "Vote.findByPriority", query = "SELECT v FROM Vote v WHERE v.priority = :priority")})
public class Vote implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VotePK votePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIORITY")
    private BigInteger priority;
    @JoinColumn(name = "S_ID", referencedColumnName = "S_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subject subject;
    @JoinColumn(name = "R_ID", referencedColumnName = "R_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Round round;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public Vote() {
    }

    public Vote(VotePK votePK) {
        this.votePK = votePK;
    }

    public Vote(VotePK votePK, BigInteger priority) {
        this.votePK = votePK;
        this.priority = priority;
    }

    public Vote(BigInteger pId, BigInteger rId, BigInteger sId) {
        this.votePK = new VotePK(pId, rId, sId);
    }

    public VotePK getVotePK() {
        return votePK;
    }

    public void setVotePK(VotePK votePK) {
        this.votePK = votePK;
    }

    public BigInteger getPriority() {
        return priority;
    }

    public void setPriority(BigInteger priority) {
        this.priority = priority;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (votePK != null ? votePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.votePK == null && other.votePK != null) || (this.votePK != null && !this.votePK.equals(other.votePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vote[ votePK=" + votePK + " ]";
    }
    
}
