/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Person;
import entities.Subject;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Mads
 */
public interface IUtilities {

    public HashMap<String, Integer> getSatisfaction(Collection<Person> persons, Collection<Subject> subjects);
}
