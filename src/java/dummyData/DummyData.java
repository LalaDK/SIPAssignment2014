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
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thomas
 */
public class DummyData implements IDataManager {

    public static DummyData instance;
    Collection<Subject> subjects;
    Collection<Person> persons;
    Collection<Vote> votes;
    Collection<Vote> bjarkevote;
    Collection<Vote> martinvote;
    Collection<Vote> nicklasvote;
    Collection<Vote> henrikote;

    private DummyData() {
        subjects = new ArrayList<>();
        persons = new ArrayList<>();
        votes = new ArrayList<>();
        bjarkevote = new ArrayList<>();
        martinvote = new ArrayList<>();
        nicklasvote = new ArrayList<>();
        henrikote = new ArrayList<>();
        
        //Subjects
        Subject Csharp = new Subject();
        Csharp.setSId(new BigDecimal(String.valueOf(1)));
        Csharp.setSubjectname("C#");
        Csharp.setDescription("Test Description");
        Csharp.setPool('a');

        Subject SWDesign = new Subject();
        SWDesign.setSId(new BigDecimal(String.valueOf(2)));
        SWDesign.setSubjectname("Software Design");
        SWDesign.setDescription("Test Description");
        SWDesign.setPool('b');

        Subject Android = new Subject();
        Android.setSId(new BigDecimal(String.valueOf(3)));
        Android.setSubjectname("Android");
        Android.setDescription("Test Description");
        Android.setPool('c');

        Subject Python = new Subject();
        Python.setSId(new BigDecimal(String.valueOf(4)));
        Python.setSubjectname("Python");
        Python.setDescription("Test Description");
        Python.setPool('c');

        Subject MordernFunc = new Subject();
        MordernFunc.setSId(new BigDecimal(String.valueOf(5)));
        MordernFunc.setSubjectname("Mordern Functional Programming");
        MordernFunc.setDescription("Test Description");
        MordernFunc.setPool('c');

        Subject Databases = new Subject();
        Databases.setSId(new BigDecimal(String.valueOf(6)));
        Databases.setSubjectname("Databases");
        Databases.setDescription("Test Description");
        Databases.setPool('c');

        Subject TDD = new Subject();
        TDD.setSId(new BigDecimal(String.valueOf(7)));
        TDD.setSubjectname("Testdriven Developement");
        TDD.setDescription("Test Description");
        TDD.setPool('c');

        Subject Games = new Subject();
        Games.setSId(new BigDecimal(String.valueOf(8)));
        Games.setSubjectname("Games");
        Games.setDescription("Test Description");
        Games.setPool('c');

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
        //Setting up bjarkes votes
        Vote bjarkeP11 = new Vote();
        bjarkeP11.setPriority(new BigInteger(String.valueOf(1)));
        bjarkeP11.setRound(round);
        bjarkeP11.setSubject(Csharp);
        votes.add(bjarkeP11);
        bjarkevote.add(bjarkeP11);

        Vote bjarkeP12 = new Vote();
        bjarkeP12.setPriority(new BigInteger(String.valueOf(1)));
        bjarkeP12.setRound(round);
        bjarkeP12.setSubject(SWDesign);
        votes.add(bjarkeP12);
        bjarkevote.add(bjarkeP12);

        Vote bjarkeP21 = new Vote();
        bjarkeP21.setPriority(new BigInteger(String.valueOf(2)));
        bjarkeP21.setRound(round);
        bjarkeP21.setSubject(Android);
        votes.add(bjarkeP21);
        bjarkevote.add(bjarkeP21);

        Vote bjarkeP22 = new Vote();
        bjarkeP22.setPriority(new BigInteger(String.valueOf(2)));
        bjarkeP22.setRound(round);
        bjarkeP22.setSubject(Python);
        votes.add(bjarkeP22);
        bjarkevote.add(bjarkeP22);

        bjarke.setVoteCollection(bjarkevote);

        //Setting up martin votes
        Vote martinP11 = new Vote();
        martinP11.setPriority(new BigInteger(String.valueOf(1)));
        martinP11.setRound(round);
        martinP11.setSubject(MordernFunc);
        votes.add(martinP11);
        martinvote.add(martinP11);

        Vote martinP12 = new Vote();
        martinP12.setPriority(new BigInteger(String.valueOf(1)));
        martinP12.setRound(round);
        martinP12.setSubject(SWDesign);
        votes.add(martinP12);
        martinvote.add(martinP12);

        Vote martinP21 = new Vote();
        martinP21.setPriority(new BigInteger(String.valueOf(2)));
        martinP21.setRound(round);
        martinP21.setSubject(Databases);
        votes.add(martinP21);
        martinvote.add(martinP21);

        Vote martinP22 = new Vote();
        martinP22.setPriority(new BigInteger(String.valueOf(2)));
        martinP22.setRound(round);
        martinP22.setSubject(TDD);
        votes.add(martinP22);
        martinvote.add(martinP22);

        martin.setVoteCollection(martinvote);

        //Setting up Henrik vote
        Vote henrikP11 = new Vote();
        henrikP11.setPriority(new BigInteger(String.valueOf(1)));
        henrikP11.setRound(round);
        henrikP11.setSubject(Android);
        votes.add(henrikP11);
        henrikote.add(henrikP11);

        Vote henrikP12 = new Vote();
        henrikP12.setPriority(new BigInteger(String.valueOf(1)));
        henrikP12.setRound(round);
        henrikP12.setSubject(Games);
        votes.add(henrikP12);
        henrikote.add(henrikP12);

        Vote henrikP21 = new Vote();
        henrikP21.setPriority(new BigInteger(String.valueOf(2)));
        henrikP21.setRound(round);
        henrikP21.setSubject(Csharp);
        votes.add(henrikP21);
        henrikote.add(henrikP21);

        Vote henrikP22 = new Vote();
        henrikP22.setPriority(new BigInteger(String.valueOf(2)));
        henrikP22.setRound(round);
        henrikP22.setSubject(Databases);
        votes.add(henrikP22);
        henrikote.add(henrikP22);

        henrik.setVoteCollection(henrikote);

        //Setting up nicklas vote
        Vote nicklasP11 = new Vote();
        nicklasP11.setPriority(new BigInteger(String.valueOf(1)));
        nicklasP11.setRound(round);
        nicklasP11.setSubject(Python);
        votes.add(nicklasP11);
        nicklasvote.add(nicklasP11);

        Vote nicklasP12 = new Vote();
        nicklasP12.setPriority(new BigInteger(String.valueOf(1)));
        nicklasP12.setRound(round);
        nicklasP12.setSubject(MordernFunc);
        votes.add(nicklasP12);
        nicklasvote.add(nicklasP12);

        Vote nicklasP21 = new Vote();
        nicklasP21.setPriority(new BigInteger(String.valueOf(2)));
        nicklasP21.setRound(round);
        nicklasP21.setSubject(SWDesign);
        votes.add(nicklasP21);
        nicklasvote.add(nicklasP21);

        Vote nicklasP22 = new Vote();
        nicklasP22.setPriority(new BigInteger(String.valueOf(2)));
        nicklasP22.setRound(round);
        nicklasP22.setSubject(TDD);
        votes.add(nicklasP22);
        nicklasvote.add(nicklasP22);

        nicklas.setVoteCollection(nicklasvote);
    }

    public static DummyData getInstance(){
        if(instance == null){
            instance = new DummyData();
        }
        return instance;
    }
    
    @Override
    public Collection<Subject> getAllSubjects() {
        return subjects;
    }

    @Override
    public Collection<Subject> getAllSubjectsFromRound(int round) {
        //Needs update
        return subjects;
    }

    @Override
    public int getAmountOfVotesFromSubject(int round, int subjectId) {
        int result = 0;
        for(Vote v : votes){
            if((v.getRound().getRId() == new BigDecimal(String.valueOf(round)) && (v.getSubject().getSId() == new BigDecimal(String.valueOf(subjectId))))){
                result++;
            }
        }
        return result;
    }

    @Override
    public Collection<Person> getAllPersonsInRound(int round) {
        //Needs work, all persons in all rounds
        return persons;
    }

    @Override
    public void saveAllSubjects(Collection<Subject> subjects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Subject> getSubjectsFromPool(char pool) {
        Collection<Subject> tmp = new ArrayList<>();
        for (Subject s : subjects) {
            if (s.getPool() == pool){
                tmp.add(s);
            }
        }
        return tmp;
    }

    @Override
    public Collection<Person> getAllPersons() {
        return persons;
    }

    @Override
    public void updatePoolOnSubject(int subjectId, char pool) {
    for(Subject s : subjects){
        if(s.getSId() == new BigDecimal(String.valueOf(subjectId))){
            s.setPool(pool);
        }
    }
    }
    

}
