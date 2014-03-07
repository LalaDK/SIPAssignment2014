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
        // Hent runder hvor rundno er den givne parameter
        List<Round> subjectsInRound = em.createNamedQuery("Round.findByRoundno", Round.class).setParameter("roundno", round).getResultList();

        // Resultatliste
        List<Subject> result = new ArrayList<>();

        // For hver runde (som alle er den givne runde), tilføj faget til resultatlisten
        for (int i = 0; i < subjectsInRound.size(); i++) {
            Subject s = subjectsInRound.get(i).getSId();
            result.add(s);
        }
        return result;
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
