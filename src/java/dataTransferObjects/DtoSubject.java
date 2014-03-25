/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataTransferObjects;

/**
 *
 * @author Thomas
 */
public class DtoSubject {
    private int sId;
    private String subjectname;
    private String description;
    private int firstRoundFirstPriorityVotes;
    private int firstRoundSecondPriorityVotes;
    private int secondRoundFirstPriorityVotes;
    private int secondRoundSecondPriorityVotes;
    private String pool;
    
    public DtoSubject() {
    }    

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFirstRoundFirstPriorityVotes() {
        return firstRoundFirstPriorityVotes;
    }

    public void setFirstRoundFirstPriorityVotes(int firstRoundFirstPriorityVotes) {
        this.firstRoundFirstPriorityVotes = firstRoundFirstPriorityVotes;
    }

    public int getFirstRoundSecondPriorityVotes() {
        return firstRoundSecondPriorityVotes;
    }

    public void setFirstRoundSecondPriorityVotes(int firstRoundSecondPriorityVotes) {
        this.firstRoundSecondPriorityVotes = firstRoundSecondPriorityVotes;
    }

    public int getSecondRoundFirstPriorityVotes() {
        return secondRoundFirstPriorityVotes;
    }

    public void setSecondRoundFirstPriorityVotes(int secondRoundFirstPriorityVotes) {
        this.secondRoundFirstPriorityVotes = secondRoundFirstPriorityVotes;
    }

    public int getSecondRoundSecondPriorityVotes() {
        return secondRoundSecondPriorityVotes;
    }

    public void setSecondRoundSecondPriorityVotes(int secondRoundSecondPriorityVotes) {
        this.secondRoundSecondPriorityVotes = secondRoundSecondPriorityVotes;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }
    
    
}
