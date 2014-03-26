/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import dataTransferObjects.DtoStudent;
import dataTransferObjects.DtoSubject;
import entities.Person;
import entities.Round;
import entities.Subject;
import entities.Vote;
import interfaces.IDataManager;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilities.DtoAssembler;

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
    public Collection<DtoSubject> getAllSubjectsFromRound(int round) {
        // Hent runder hvor rundno er den givne parameter
        List<Round> subjectsInRound = em.createNamedQuery("Round.findByRoundno", Round.class).setParameter("roundno", round).getResultList();

        // Resultatliste
        List<Subject> result = new ArrayList<>();

        // For hver runde (som alle er den givne runde), tilføj faget til resultatlisten
        for (int i = 0; i < subjectsInRound.size(); i++) {
            Subject s = subjectsInRound.get(i).getSId();
            result.add(s);
        }
        return DtoAssembler.subjectsToDtoSubjects(result);
    }

    @Override
    public int getAmountOfVotesFromSubject(int round, int subjectId) {
        return em.createNamedQuery("Vote.findBySIdAndRId").setParameter("rId", round).setParameter("sId", subjectId).getResultList().size();
    }

    @Override
    public Collection<Person> getAllPersonsInRound(int round) {
        Query q = em.createNamedQuery("Person.findAll", Person.class);
        Collection<Person> persons = q.getResultList();
        Collection<Person> result = new ArrayList<>();
        for (Person p : persons) {
            for (Vote v : p.getVoteCollection()) {
                if (v.getRound().getRoundno().intValue() == round) {
                    result.add(p);
                    break;
                }
            }
        }
        return result;
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
        Query q = em.createNamedQuery("Subject.findByPool", Subject.class);
        q.setParameter("pool", pool);
        return q.getResultList();
    }

    @Override
    public Collection<DtoStudent> getAllStudents() {
        Query q = em.createNamedQuery("Person.findByPosition", Person.class);
        q.setParameter("position", 'S');
        return q.getResultList();
    }

    @Override
    public Collection<Person> getAllPersons() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public void updatePoolOnSubject(int subjectId, char pool) {
        Subject s = em.createNamedQuery("Subject.findBySId", Subject.class).setParameter("sId", subjectId).getSingleResult();
        s.setPool(pool);
        persist(s);
    }

    @Override
    public HashMap<String, ArrayList<DtoStudent>> getSatisfaction() {
        Collection<Person> persons = getAllPersonsInRound(1);
        Collection<Subject> subjects = getAllSubjects();
        HashMap<String, ArrayList<Person>> tmp = utilities.Utilities.getSatisfaction(subjects, persons);
        HashMap<String, ArrayList<DtoStudent>> students = new HashMap();
        for(String k : tmp.keySet()){            
            students.put(k, new ArrayList<>(DtoAssembler.studentsToDtoStudents(tmp.get(k))));
        }
        return students;
    }

    @Override
    public void saveVote(Vote vote) {
        persist(vote);
    }

    @Override
    
    public void removeVotes(BigInteger pId, BigInteger rId) {
        Query q = em.createNamedQuery("Vote.findByPIdAndRId");
        q.setParameter("pId", pId);
        q.setParameter("rId", rId);
        Collection<Vote> result = q.getResultList();
        for (Vote v : result) {
            em.remove(v);
        }
    }

    @Override
    public Collection<DtoStudent> getAllStudentsInRound(int round) {
        Query q = em.createNamedQuery("Person.findAll", Person.class);
        Collection<Person> persons = q.getResultList();
        List<Person> result = new ArrayList<>();
        for (Person p : persons) {
            for (Vote v : p.getVoteCollection()) {
                if (v.getRound().getRoundno().intValue() == round) {
                    result.add(p);
                    break;
                }
            }
        }
        return DtoAssembler.studentsToDtoStudents(result);
    }
}
