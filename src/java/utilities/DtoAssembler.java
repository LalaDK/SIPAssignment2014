/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import dataTransferObjects.DtoSubject;
import entities.Subject;
import entities.Vote;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Thomas
 */
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
    
    public static Collection<DtoSubject> subjectsToDtoSubjects(List<Subject> subjects){
        Collection<DtoSubject> dtoSubjects = new ArrayList();
        for(Subject s: subjects){
            dtoSubjects.add(subjectToDtoSubject(s));
        }
        return dtoSubjects;
    }
}
