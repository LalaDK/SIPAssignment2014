/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import entities.Person;
import entities.Subject;
import interfaces.IDataManager;
import interfaces.IUtilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sessionbeans.DataManager;

/**
 *
 * @author Mads
 */
public class UtilityJUnitTest {

    private Collection<Subject> subjectsFromPoolA;
    private IDataManager dm;

    public UtilityJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dm = new DataManager();
        subjectsFromPoolA = dm.getSubjectsFromPool('a');
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUtilityClass() {
        // Data for testing
        Collection<Person> persons = dm.getAllPersonsInRound(2);
        Collection<Subject> subjects = dm.getAllSubjectsFromRound(2);

        IUtilities instance = null;

        HashMap<String, Integer> result = instance.getSatisfaction(persons, subjects);
//        result.
    }

    @Test
    public void testGetSubjectsFromGivenPool() {
        Collection<Subject> subjects = dm.getSubjectsFromPool('a');
        
        assertTrue("testGetSubjectsFromGivenPool() returned zero or null results", subjects.size() > 0);
        
        ArrayList<Subject> t = new ArrayList<>();
        t.addAll(subjects);
        
        assertTrue("First selected subject is not in pool A", t.get(0).getPool() == 'a');
    }
}
