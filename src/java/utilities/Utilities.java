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
        HashMap<String, Integer> result = getLevelsOfSatisfaction();
        ArrayList<Subject> poolA = new ArrayList<>();
        ArrayList<Subject> poolB = new ArrayList<>();

        sortSubjectsIntoPools(subjects, poolA, poolB);

        for (Person p : persons) {

            // Divide each persons votes in first- and second priority
            ArrayList<Vote> firstPriority = new ArrayList<>();
            ArrayList<Vote> secondPriority = new ArrayList<>();

            prioritizeVotes(p, firstPriority, secondPriority);

            // Fullfillments
            boolean firstPriorityFullfilledPoolA = false;
            boolean firstPriorityFullfilledPoolB = false;
            boolean secondPriorityFullfilledPoolA = false;
            boolean secondPriorityFullfilledPoolB = false;

            // First Priority Pool A
            for (Vote vote : firstPriority) {
                for (Subject subject : poolA) {
                    if (!firstPriorityFullfilledPoolA
                            && vote.getSubject().getSId() == subject.getSId()) {
                        firstPriorityFullfilledPoolA = true;
                    }
                }
            }

            // First Priority Pool B
            for (Vote vote : firstPriority) {
                for (Subject subject : poolB) {
                    if (!firstPriorityFullfilledPoolB
                            && vote.getSubject().getSId() == subject.getSId()) {
                        firstPriorityFullfilledPoolB = true;
                    }
                }
            }

            // Second Priority Pool A
            for (Vote vote : secondPriority) {
                for (Subject subject : poolA) {
                    if (!firstPriorityFullfilledPoolA
                            && vote.getSubject().getSId() == subject.getSId()) {
                        secondPriorityFullfilledPoolA = true;
                    }
                }
            }

            // Second Priority Pool B
            for (Vote vote : secondPriority) {
                for (Subject subject : poolB) {
                    if (!firstPriorityFullfilledPoolB
                            && vote.getSubject().getSId() == subject.getSId()) {
                        secondPriorityFullfilledPoolB = true;
                    }
                }
            }
            decideLevelOfSatisfaction(
                    firstPriorityFullfilledPoolA,
                    firstPriorityFullfilledPoolB, result,
                    secondPriorityFullfilledPoolB,
                    secondPriorityFullfilledPoolA);
        }

        return result;
    }

    private static void prioritizeVotes(Person p, ArrayList<Vote> firstPriority, 
            ArrayList<Vote> secondPriority) {
        for (Vote v : p.getVoteCollection()) {
            if (v.getPriority().intValue() == 1) {
                firstPriority.add(v);
            } else {
                secondPriority.add(v);
            }
        }
    }

    private static void decideLevelOfSatisfaction(
            boolean firstPriorityFullfilledPoolA, 
            boolean firstPriorityFullfilledPoolB, 
            HashMap<String, Integer> result, 
            boolean secondPriorityFullfilledPoolB, 
            boolean secondPriorityFullfilledPoolA) {
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

    private static void sortSubjectsIntoPools(ArrayList<Subject> subjects, ArrayList<Subject> poolA, ArrayList<Subject> poolB) {
        for (Subject s : subjects) {
            if (s.getPool() == 'a') {
                poolA.add(s);
            }

            if (s.getPool() == 'b') {
                poolB.add(s);
            }
        }
    }

    private static HashMap<String, Integer> getLevelsOfSatisfaction() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("very_satisfied", 0);
        result.put("satisfied", 0);
        result.put("above_average", 0);
        result.put("below_average", 0);
        result.put("unsatisfied", 0);
        result.put("very_unsatisfied", 0);
        return result;
    }
}
