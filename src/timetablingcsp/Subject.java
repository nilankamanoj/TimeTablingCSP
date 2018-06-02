/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablingcsp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nilanka
 */
public class Subject implements Comparable {
    private List<String> possibleTimeSlots = new ArrayList<String>();
    private String timeSlot;
    private String room;
    private boolean compulsory;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompulsory() {
        return compulsory;
    }

    public void setCompulsory(boolean compulsory) {
        this.compulsory = compulsory;
    }
    
    public List<String> getPossibleTimeSlots() {
        return possibleTimeSlots;
    }
    public String getTimeSlot() {
        return timeSlot;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getRoom() {
        return room;
    }
    public Boolean used(String room, String timeSlot){
        return this.room.equals(room)&& this.timeSlot.equals(timeSlot);
    }
    public int getSize(){
        return this.possibleTimeSlots.size();
    }

    @Override
    public int compareTo(Object o) {
        Subject compSub = (Subject)o; 
        if(this.getSize()>compSub.getSize())return(1);
        if(this.getSize()==compSub.getSize())return(0);
        if(this.getSize()<compSub.getSize())return(-1);
        else return 10;
    }
    
    public void addPossibleTimeSlot(String timeSlot){
        this.possibleTimeSlots.add(timeSlot);
    }
  
    
    
    
}
