/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataTransferObjects;

import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class DtoStudent {

    private String name;
    private int pId;
    private ArrayList<String> firstRoundFirstPriority;
    private ArrayList<String> firstRoundSecondPriority;
    private ArrayList<String> secondRoundFirstPriority;
    private ArrayList<String> secondRoundSecondPriority;

    public DtoStudent() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public ArrayList<String> getFirstRoundFirstPriority() {
        return firstRoundFirstPriority;
    }

    public void setFirstRoundFirstPriority(ArrayList<String> firstRoundFirstPriority) {
        this.firstRoundFirstPriority = firstRoundFirstPriority;
    }

    public ArrayList<String> getFirstRoundSecondPriority() {
        return firstRoundSecondPriority;
    }

    public void setFirstRoundSecondPriority(ArrayList<String> firstRoundSecondPriority) {
        this.firstRoundSecondPriority = firstRoundSecondPriority;
    }

    public ArrayList<String> getSecondRoundFirstPriority() {
        return secondRoundFirstPriority;
    }

    public void setSecondRoundFirstPriority(ArrayList<String> secondRoundFirstPriority) {
        this.secondRoundFirstPriority = secondRoundFirstPriority;
    }

    public ArrayList<String> getSecondRoundSecondPriority() {
        return secondRoundSecondPriority;
    }

    public void setSecondRoundSecondPriority(ArrayList<String> secondRoundSecondPriority) {
        this.secondRoundSecondPriority = secondRoundSecondPriority;
    }



    
    
}
