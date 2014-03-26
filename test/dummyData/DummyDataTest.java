/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummyData;

import dataTransferObjects.DtoStudent;
import dataTransferObjects.DtoSubject;
import entities.Person;
import entities.Subject;
import entities.Vote;
import interfaces.IDataManager;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Mads
 */
public class DummyDataTest {

    public DummyDataTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        DummyData.getInstance().killInstance();
    }

    /**
     * Test of getInstance method, of class DummyData.
     */
    @Test
    public void testGetInstance() {
        DummyData result = DummyData.getInstance();
        assertTrue("Instance returned is not an instance of IDataManager", result instanceof IDataManager);
    }

    /**
     * Test of getAllSubjects method, of class DummyData.
     */
    @Test
    public void testGetAllSubjects() {
        DummyData instance = DummyData.getInstance();
        Collection<Subject> result = instance.getAllSubjects();
        assertTrue("Expected amount of persons, differes from '8'", result.size() == 8);
    }

    /**
     * Test of getAllSubjectsFromRound method, of class DummyData.
     */
    @Test
    public void testGetAllSubjectsFromRound() {
        DummyData instance = DummyData.getInstance();
        int round = 2;
        Collection<DtoSubject> result = instance.getAllSubjectsFromRound(round);
        assertTrue("Expected subjects in round 2, is 8 subjects", result.size() == 8);
    }

    /**
     * Test of getAmountOfVotesFromSubject method, of class DummyData.
     */
    @Test
    public void testGetAmountOfVotesFromSubject() {
        DummyData instance = DummyData.getInstance();
        int result = instance.getAmountOfVotesFromSubject(2, 1);
//        assertEquals(result.s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPersonsInRound method, of class DummyData.
     */
    @Test
    public void testGetAllPersonsInRound() {
        DummyData instance = DummyData.getInstance();
        Collection<Person> result = instance.getAllPersonsInRound(2);
        assertTrue(result.size() == 4);
    }

    /**
     * Test of saveAllSubjects method, of class DummyData.
     */
    @Test
    @Ignore("Not implemented yet")
    public void testSaveAllSubjects() {
        System.out.println("saveAllSubjects");
        Collection<Subject> subjects = null;
        DummyData instance = null;
        instance.saveAllSubjects(subjects);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubjectsFromPool method, of class DummyData.
     */
    @Test
    public void testGetSubjectsFromPool() {
        DummyData instance = DummyData.getInstance();
        Collection<Subject> result = instance.getSubjectsFromPool('a');
        System.out.println(result.size());
        assertTrue(result.size() == 4);
    }

    /**
     * Test of getAllPersons method, of class DummyData.
     */
    @Test
    public void testGetAllPersons() {
        DummyData instance = DummyData.getInstance();
        Collection<Person> result = instance.getAllPersons();
        assertTrue(result.size() == 4);
    }

    /**
     * Test of updatePoolOnSubject method, of class DummyData.
     */
    @Test
    public void testUpdatePoolOnSubject() {
        System.out.println("updatePoolOnSubject");
        int subjectId = 0;
        char pool = ' ';
        DummyData instance = null;
        instance.updatePoolOnSubject(subjectId, pool);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSatisfaction method, of class DummyData.
     */
    @Ignore
    @Test
    public void testGetSatisfaction() {
        System.out.println("getSatisfaction");
        DummyData instance = null;
        HashMap<String, Integer> expResult = null;
//        HashMap<String, Integer> result = instance.getSatisfaction();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllStudents method, of class DummyData.
     */
    @Test
    public void testGetAllStudents() {
        DummyData instance = DummyData.getInstance();
        Collection<DtoStudent> result = instance.getAllStudents();
        assertTrue(result.size() == 4);
    }

    /**
     * Test of saveVote method, of class DummyData.
     */
    @Test
    @Ignore("Not implemented yet")
    public void testSaveVote() {
        System.out.println("saveVote");
        Vote vote = null;
        DummyData instance = null;
        instance.saveVote(vote);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeVotes method, of class DummyData.
     */
    @Test
    @Ignore("Not implemented yet")
    public void testRemoveVotes() {
        System.out.println("removeVotes");
        BigInteger pId = null;
        BigInteger rId = null;
        DummyData instance = null;
        instance.removeVotes(pId, rId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
