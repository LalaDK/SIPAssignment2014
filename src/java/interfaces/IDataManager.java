/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Subject;
import entities.Person;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Local;

@Local
public interface IDataManager {

    public Collection<Subject> getAllSubjects();

    public Collection<Subject> getAllSubjectsFromRound(int round);

    public int getAmountOfVotesFromSubject(int round, int subjectId);

    public Collection<Person> getAllPersonsInRound(int round);

    public void saveAllSubjects(Collection<Subject> subjects);
    
    public Collection<Subject> getSubjectsFromPool(char pool);

    public Collection<Person> getAllPersons();
    
    public void updatePoolOnSubject(int subjectId, char pool);
    
    public HashMap<String, Integer> getSatisfaction();
}
