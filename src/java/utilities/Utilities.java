/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Person;
import entities.Subject;
import entities.Vote;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mads
 */
public class Utilities {

    public static HashMap<String, Integer> getSatisfaction(ArrayList<Subject> subjects, ArrayList<Person> persons) {

        HashMap<String, Integer> result = new HashMap<>();
        result.put("very_satisfied", 0);
        result.put("satisfied", 0);
        result.put("above_average", 0);
        result.put("below_average", 0);
        result.put("unsatisfied", 0);
        result.put("very_unsatisfied", 0);

        ArrayList<Subject> poolA = new ArrayList<>();
        ArrayList<Subject> poolB = new ArrayList<>();

        for (Subject s : subjects) {
            if (s.getPool() == 'a') {
                poolA.add(s);
            }

            if (s.getPool() == 'b') {
                poolB.add(s);
            }
        }

        for (Person p : persons) {

            // Divide each persons votes in first- and second priority
            ArrayList<Vote> firstPriority = new ArrayList<>();
            ArrayList<Vote> secondPriority = new ArrayList<>();

            for (Vote v : p.getVoteCollection()) {
                if (v.getPriority().intValue() == 1) {
                    firstPriority.add(v);
                } else {
                    secondPriority.add(v);
                }
            }

            // Fullfillments
            boolean firstPriorityFullfilledPoolA = false;
            boolean firstPriorityFullfilledPoolB = false;
            boolean secondPriorityFullfilledPoolA = false;
            boolean secondPriorityFullfilledPoolB = false;

            // First Priority Pool A
            for (Vote vote : firstPriority) {
                for (Subject subject : poolA) {
                    if (!firstPriorityFullfilledPoolA && vote.getSubject().getSId() == subject.getSId()) {
                        firstPriorityFullfilledPoolA = true;
                    }
                }
            }

            // First Priority Pool B
            for (Vote vote : firstPriority) {
                for (Subject subject : poolB) {
                    if (!firstPriorityFullfilledPoolB && vote.getSubject().getSId() == subject.getSId()) {
                        firstPriorityFullfilledPoolB = true;
                    }
                }
            }

            // Second Priority Pool A
            for (Vote vote : secondPriority) {
                for (Subject subject : poolA) {
                    if (!firstPriorityFullfilledPoolA && vote.getSubject().getSId() == subject.getSId()) {
                        secondPriorityFullfilledPoolA = true;
                    }
                }
            }

            // Second Priority Pool B
            for (Vote vote : secondPriority) {
                for (Subject subject : poolB) {
                    if (!firstPriorityFullfilledPoolB && vote.getSubject().getSId() == subject.getSId()) {
                        secondPriorityFullfilledPoolB = true;
                    }
                }
            }

            /*
             boolean firstPriorityFullfilledPoolA = false;
             boolean firstPriorityFullfilledPoolB = false;
             boolean secondPriorityFullfilledPoolA = false;
             boolean secondPriorityFullfilledPoolB = false;
             */
            if (firstPriorityFullfilledPoolA && firstPriorityFullfilledPoolB) {
                result.put("very_satisfied", result.get("very_satisfied") + 1);
            } else if ((firstPriorityFullfilledPoolA && secondPriorityFullfilledPoolB)
                    || (firstPriorityFullfilledPoolB && secondPriorityFullfilledPoolA)) {
                result.put("satisfied", result.get("satisfied") + 1);
            } else if (secondPriorityFullfilledPoolA && secondPriorityFullfilledPoolB) {
                result.put("above_average", result.get("above_average") + 1);
            } else if (firstPriorityFullfilledPoolA || firstPriorityFullfilledPoolB) {
                result.put("below_average", result.get("below_average") + 1);
            } else if (secondPriorityFullfilledPoolA || secondPriorityFullfilledPoolB) {
                result.put("unsatisfied", result.get("unsatisfied") + 1);
            } else {
                result.put("very_unsatisfied", result.get("very_unsatisfied") + 1);
            }
        }

        // Print result for testing
        for (String k : result.keySet()) {
            System.out.println(result.get(k) + " - " + k);
        }

        return result;
    }
}
