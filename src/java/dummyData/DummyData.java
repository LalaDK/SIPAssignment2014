/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummyData;

import entities.Person;
import entities.Round;
import entities.Subject;
import entities.Vote;
import interfaces.IDataManager;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

/**
 *
 * @author Thomas
 */
public class DummyData implements IDataManager {

    Collection<Subject> subjects;
    Collection<Person> persons;
    Collection<Vote> votes;

    public DummyData(Collection<Subject> subjects) {
        this.subjects = subjects;

        Subject Csharp = new Subject();
        Csharp.setSId(new BigDecimal(String.valueOf(1)));

        //Subjects
        Subject SWDesign = new Subject();
        SWDesign.setSId(new BigDecimal(String.valueOf(2)));

        Subject Android = new Subject();
        Android.setSId(new BigDecimal(String.valueOf(3)));

        Subject Python = new Subject();
        Python.setSId(new BigDecimal(String.valueOf(4)));

        Subject MordernFunc = new Subject();
        MordernFunc.setSId(new BigDecimal(String.valueOf(5)));

        Subject Databases = new Subject();
        Databases.setSId(new BigDecimal(String.valueOf(6)));

        Subject TDD = new Subject();
        TDD.setSId(new BigDecimal(String.valueOf(7)));

        Subject Games = new Subject();
        Games.setSId(new BigDecimal(String.valueOf(8)));

        subjects.add(Csharp);
        subjects.add(Android);
        subjects.add(Databases);
        subjects.add(Games);
        subjects.add(MordernFunc);
        subjects.add(Python);
        subjects.add(SWDesign);
        subjects.add(TDD);

        //Persons
        Person bjarke = new Person();
        bjarke.setPId(new BigDecimal(String.valueOf(1)));

        Person martin = new Person();
        martin.setPId(new BigDecimal(String.valueOf(2)));

        Person henrik = new Person();
        henrik.setPId(new BigDecimal(String.valueOf(3)));

        Person nicklas = new Person();
        nicklas.setPId(new BigDecimal(String.valueOf(4)));

        persons.add(bjarke);
        persons.add(martin);
        persons.add(henrik);
        persons.add(nicklas);

//Round
        Round round = new Round(new BigDecimal(String.valueOf(2)));

        //Votes
        Vote bjarkeP11 = new Vote();
        bjarkeP11.setPriority(new BigInteger(String.valueOf(1)));
        bjarkeP11.setRound(round);
        votes.add(bjarkeP11);

        Vote bjarkeP12 = new Vote();
        bjarkeP12.setPriority(new BigInteger(String.valueOf(1)));
        bjarkeP12.setRound(round);
        votes.add(bjarkeP12);

        Vote bjarkeP21 = new Vote();
        bjarkeP21.setPriority(new BigInteger(String.valueOf(2)));
        bjarkeP21.setRound(round);
        votes.add(bjarkeP21);

        Vote bjarkeP22 = new Vote();
        bjarkeP22.setPriority(new BigInteger(String.valueOf(2)));
        bjarkeP22.setRound(round);
        votes.add(bjarkeP22);

        Vote martinP11 = new Vote();
        martinP11.setPriority(new BigInteger(String.valueOf(1)));
        martinP11.setRound(round);
        votes.add(martinP11);

        Vote martinP12 = new Vote();
        martinP12.setPriority(new BigInteger(String.valueOf(1)));
        martinP12.setRound(round);
        votes.add(martinP12);

        Vote martinP21 = new Vote();
        martinP21.setPriority(new BigInteger(String.valueOf(2)));
        martinP21.setRound(round);
                votes.add(martinP21);


        Vote martinP22 = new Vote();
        martinP22.setPriority(new BigInteger(String.valueOf(2)));
        martinP22.setRound(round);
                votes.add(martinP22);


        Vote henrikP11 = new Vote();
        henrikP11.setPriority(new BigInteger(String.valueOf(1)));
        henrikP11.setRound(round);
        votes.add(henrikP11);

        Vote henrikP12 = new Vote();
        henrikP12.setPriority(new BigInteger(String.valueOf(1)));
        henrikP12.setRound(round);
        votes.add(henrikP12);

        Vote henrikP21 = new Vote();
        henrikP21.setPriority(new BigInteger(String.valueOf(2)));
        henrikP21.setRound(round);
        votes.add(henrikP21);

        Vote henrikP22 = new Vote();
        henrikP22.setPriority(new BigInteger(String.valueOf(2)));
        henrikP22.setRound(round);
        votes.add(henrikP22);

        Vote nicklasP11 = new Vote();
        nicklasP11.setPriority(new BigInteger(String.valueOf(1)));
        nicklasP11.setRound(round);
        votes.add(nicklasP11);

        Vote nicklasP12 = new Vote();
        nicklasP12.setPriority(new BigInteger(String.valueOf(1)));
        nicklasP12.setRound(round);
                votes.add(nicklasP12);


        Vote nicklasP21 = new Vote();
        nicklasP21.setPriority(new BigInteger(String.valueOf(2)));
        nicklasP21.setRound(round);
                votes.add(nicklasP21);


        Vote nicklasP22 = new Vote();
        nicklasP22.setPriority(new BigInteger(String.valueOf(2)));
        nicklasP22.setRound(round);
                votes.add(nicklasP22);

    }

    @Override
    public Collection<Subject> getAllSubjects() {
        return subjects;
    }

    @Override
    public Collection<Subject> getAllSubjectsFromRound(int round) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
