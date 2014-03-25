package utilities;

import entities.Person;
import entities.Subject;
import entities.Vote;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Utilities {

    public static HashMap<String, ArrayList<Person>> getSatisfaction(Collection<Subject> subjects, Collection<Person> persons) {
        HashMap<String, ArrayList<Person>> result = getLevelsOfSatisfaction();
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
                    secondPriorityFullfilledPoolA, p);
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
            HashMap<String, ArrayList<Person>> result,
            boolean secondPriorityFullfilledPoolB,
            boolean secondPriorityFullfilledPoolA, Person p) {
        
        if (firstPriorityFullfilledPoolA && firstPriorityFullfilledPoolB) {
            result.get("very_satisfied").add(p);
        } else if ((firstPriorityFullfilledPoolA && secondPriorityFullfilledPoolB)
                || (firstPriorityFullfilledPoolB && secondPriorityFullfilledPoolA)) {
            result.get("satisfied").add(p);
        } else if (secondPriorityFullfilledPoolA && secondPriorityFullfilledPoolB) {
            result.get("above_average").add(p);
        } else if (firstPriorityFullfilledPoolA || firstPriorityFullfilledPoolB) {
            result.get("below_average").add(p);
        } else if (secondPriorityFullfilledPoolA || secondPriorityFullfilledPoolB) {
            result.get("unsatisfied").add(p);
        } else {
            result.get("very_unsatisfied").add(p);
        }
    }

    private static void sortSubjectsIntoPools(Collection<Subject> subjects, Collection<Subject> poolA, Collection<Subject> poolB) {
        for (Subject s : subjects) {
            if (s.getPool() == 'a') {
                poolA.add(s);
            }

            if (s.getPool() == 'b') {
                poolB.add(s);
            }
        }
    }

    private static HashMap<String, ArrayList<Person>> getLevelsOfSatisfaction() {
        HashMap<String, ArrayList<Person>> result = new HashMap<>();
        result.put("very_satisfied", new ArrayList<Person>());
        result.put("satisfied", new ArrayList<Person>());
        result.put("above_average", new ArrayList<Person>());
        result.put("below_average", new ArrayList<Person>());
        result.put("unsatisfied", new ArrayList<Person>());
        result.put("very_unsatisfied", new ArrayList<Person>());
        return result;
    }
}
