/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Person;
import entities.Round;
import entities.Subject;
import interfaces.IEntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mads
 */
@Stateless
public class EntityManager implements IEntityManager {

    @PersistenceContext(unitName = "SIPAssignment2014PU")
    private javax.persistence.EntityManager em;

    @Override
    public Collection<Subject> getAllSubjects() {
        return em.createNamedQuery("Subject.findAll").getResultList();
    }

    @Override
    public Collection<Subject> getAllSubjectsFromRound(int round) {
        List<Round> subjectsInRound = em.createNamedQuery("Round.findByRoundno", Round.class).setParameter("roundno", round).getResultList();
        
        System.out.println(subjectsInRound.size());
            
        List<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < subjectsInRound.size(); i++) {
            Subject s = em.createNamedQuery("Subject.findBySId", Subject.class).setParameter("sId", subjectsInRound.get(i).getSId().getSId()).getSingleResult();
            subjects.add(s);
        }
        return subjects;
    }

    @Override
    public int getAmountOfVotesFromSubject(int round, int subjectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Person> getAllPersonsInRound(int round) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAllSubjects(Collection<Subject> subjects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void persist(Object object) {
        em.persist(object);
    }
}
