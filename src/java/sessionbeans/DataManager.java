/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Person;
import entities.Round;
import entities.Subject;
import entities.Vote;
import interfaces.IDataManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mads
 */
@Stateless
public class DataManager implements IDataManager {

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
        return em.createNamedQuery("Vote.findBySIdAndRId").setParameter("rId", round).setParameter("sId", subjectId).getResultList().size();
    }

    @Override
    public Collection<Person> getAllPersonsInRound(int round) {
        // Få fat i runder med givne rundenummer
        Collection<Round> rounds = em.createNamedQuery("Round.findByRoundno").setParameter("roundno", round).getResultList();

        // Hent alle stemmer fra de runder
        Collection<Vote> votes = new ArrayList<>();
        for (Round value : rounds) {
            votes.addAll(value.getVoteCollection());
        }

        // Hent person fra stemme. 
        Collection<Person> persons = new ArrayList<>();
        for (Vote vote : votes) {

            persons.add(vote.getPerson());
        }
        return persons;
    }

    @Override
    public void saveAllSubjects(Collection<Subject> subjects) {
        for (Subject subject : subjects) {
            persist(subject);
        }
    }

    public void persist(Object object) {
        em.persist(object);
    }

//    @Override
//    public Collection<Subject> getSubjectsFromPool(char pool) {
//        Collection result = em.createNamedQuery("Subject.findByPool", Subject.class).setParameter("pool", pool).getResultList();
//        return result;
//    }
    @Override
    public Collection<Subject> getSubjectsFromPool(char pool) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Person> getAllPersons() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public void updatePoolOnSubject(int subjectId, char pool) {
        Subject s = em.createNamedQuery("Subject.findBySId", Subject.class).setParameter("SId", subjectId).getSingleResult();
        s.setPool(pool);
        persist(s);
    }

    @Override
    public HashMap<String, Integer> getSatisfaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
