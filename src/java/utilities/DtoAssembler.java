package utilities;

import dataTransferObjects.DtoStudent;
import dataTransferObjects.DtoSubject;
import entities.Person;
import entities.Subject;
import entities.Vote;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DtoAssembler {
    
    public static DtoSubject subjectToDtoSubject(Subject subject) {
        int firstRoundFirstPriority = 0;
        int firstRoundSecondPriority = 0;
        int secondRoundFirstPriority = 0;
        int secondRoundSecondPriority = 0;
        DtoSubject dto = new DtoSubject();
        dto.setsId(subject.getSId().intValue());
        dto.setSubjectname(subject.getSubjectname());
        dto.setDescription(subject.getDescription());
        dto.setPool(subject.getPool().toString());
        for (Vote v : subject.getVoteCollection()) {
            if (v.getPriority().intValue() == 1 && v.getRound().getRId().intValue() == 1) {
                firstRoundFirstPriority++;
            } else if (v.getPriority().intValue() == 2 && v.getRound().getRId().intValue() == 1) {
                firstRoundSecondPriority++;
            } else if (v.getPriority().intValue() == 1 && v.getRound().getRId().intValue() == 2) {
                secondRoundFirstPriority++;
            } else if (v.getPriority().intValue() == 1 && v.getRound().getRId().intValue() == 2) {
                secondRoundSecondPriority++;
            }
        }
        dto.setFirstRoundFirstPriorityVotes(firstRoundFirstPriority);
        dto.setFirstRoundSecondPriorityVotes(firstRoundSecondPriority);
        dto.setSecondRoundFirstPriorityVotes(secondRoundFirstPriority);
        dto.setSecondRoundSecondPriorityVotes(secondRoundSecondPriority);
        return dto;
    }
    
    public static Collection<DtoSubject> subjectsToDtoSubjects(List<Subject> subjects) {
        Collection<DtoSubject> dtoSubjects = new ArrayList();
        for (Subject s : subjects) {
            dtoSubjects.add(subjectToDtoSubject(s));
        }
        return dtoSubjects;
    }
    
    public static DtoStudent studentToDtoStudent(Person student) {
        DtoStudent dto = new DtoStudent();
        ArrayList<String> firstRoundFirstPriorities = new ArrayList<>();
        ArrayList<String> firstRoundSecondPriorities = new ArrayList<>();
        ArrayList<String> secondRoundFirstPriorities = new ArrayList<>();
        ArrayList<String> secondRoundSecondPriorities = new ArrayList<>();
        dto.setName(student.getName());
        dto.setpId(student.getPId().intValue());
        
        for (Vote v : student.getVoteCollection()) {
            if (v.getPriority().intValue() == 1 && v.getRound().getRId().intValue() == 1) {
                firstRoundFirstPriorities.add(v.getSubject().getSubjectname());
            } else if (v.getPriority().intValue() == 2 && v.getRound().getRId().intValue() == 1) {
                firstRoundSecondPriorities.add(v.getSubject().getSubjectname());
            } else if (v.getPriority().intValue() == 1 && v.getRound().getRId().intValue() == 2) {
                secondRoundFirstPriorities.add(v.getSubject().getSubjectname());
            } else if (v.getPriority().intValue() == 2 && v.getRound().getRId().intValue() == 2) {
                secondRoundSecondPriorities.add(v.getSubject().getSubjectname());
            }
            dto.setFirstRoundFirstPriority(firstRoundFirstPriorities);
            dto.setFirstRoundSecondPriority(firstRoundSecondPriorities);
            dto.setSecondRoundFirstPriority(secondRoundFirstPriorities);
            dto.setSecondRoundSecondPriority(secondRoundSecondPriorities);       
        }
        return dto;
    }
    
    public static Collection<DtoStudent> studentsToDtoStudents(List<Person> students) {
        Collection<DtoStudent> dtoStudents = new ArrayList<>();
        for (Person p : students) {
            dtoStudents.add(studentToDtoStudent(p));
        }
        return dtoStudents;
    }
}
