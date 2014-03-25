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

/**
 *
 * @author Thomas
 */
public class DtoAssembler {

    private static DtoSubject subjectToDtoSubject(Subject subject) {
        int firstPriority = 0;
        int secondPriority = 0;
        DtoSubject dto = new DtoSubject();
        dto.setSId(subject.getSId().intValue());
        dto.setSubjectname(subject.getSubjectname());
        dto.setDescription(subject.getDescription());
        dto.setPool(subject.getPool().toString());
        for (Vote v : subject.getVoteCollection()) {
            if (v.getPriority().intValue() == 1) {
                firstPriority++;
            } else if (v.getPriority().intValue() == 2) {
                secondPriority++;
            }
        }
        dto.setFirstPriorityVotes(firstPriority);
        dto.setSecondPriorityVotes(secondPriority);
        return dto;
    }
    
    private static ArrayList<DtoSubject> subjectsToDtoSubjects(ArrayList<Subject> subjects){
        ArrayList<DtoSubject> dtoSubjects = new ArrayList();
        for(Subject s: subjects){
            dtoSubjects.add(subjectToDtoSubject(s));
        }
        return dtoSubjects;
    }
}
