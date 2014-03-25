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
    private int firstPriorityVotes;
    private int secondPriorityVotes;
    private String pool;

    public DtoSubject() {
    }

    public DtoSubject(int sId, String subjectname, String description, int firstPriorityVotes, int secondPriorityVotes, String pool) {
        this.sId = sId;
        this.subjectname = subjectname;
        this.description = description;
        this.firstPriorityVotes = firstPriorityVotes;
        this.secondPriorityVotes = secondPriorityVotes;
        this.pool = pool;
    }

    public int getSId() {
        return sId;
    }

    public void setSId(int sId) {
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

    public int getFirstPriorityVotes() {
        return firstPriorityVotes;
    }

    public void setFirstPriorityVotes(int firstPriorityVotes) {
        this.firstPriorityVotes = firstPriorityVotes;
    }

    public int getSecondPriorityVotes() {
        return secondPriorityVotes;
    }

    public void setSecondPriorityVotes(int secondPriorityVotes) {
        this.secondPriorityVotes = secondPriorityVotes;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    
}
