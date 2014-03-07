/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Subject;
import entities.Person;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface IEntityManager {

    public Collection<Subject> getAllSubjects();

    public Collection<Subject> getAllSubjectsFromRound(int round);

    public int getAmountOfVotesFromSubject(int round, int subjectId);

    public Collection<Person> getAllPersonsInRound(int round);

    public void saveAllSubjects(Collection<Subject> subjects);
}
