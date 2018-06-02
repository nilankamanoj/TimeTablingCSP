/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablingcsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nilanka
 */
public class TimeTablingCSP {
    private static Assignment assignment;
    private static List<String> rooms = new ArrayList<String>();
    private static List<Subject> subjects = new ArrayList<Subject>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        assignment = new Assignment();
        DataReader dr = new DataReader();
        dr.readData(subjects,rooms);
        recursiveAssign(0);
        List <Subject> subs = assignment.getSubjects();
        for(int i =0;i<subs.size();i++){
            System.out.println(subs.get(i).getName()+","+subs.get(i).getTimeSlot()+","+subs.get(i).getRoom());
        }
        
        
        
    }
    
    private static boolean recursiveAssign(int pointer){
        
        if(subjects.size() == pointer) return true;
        Subject subject = subjects.get(pointer);
        for(int i = 0;i<rooms.size();i++){
            for(int j = 0; j<subject.getPossibleTimeSlots().size();j++){
                if(assignment.validate(subject.getPossibleTimeSlots().get(j), rooms.get(i), subject.isCompulsory())){
                    subject.setRoom(rooms.get(i));
                    subject.setTimeSlot(subject.getPossibleTimeSlots().get(j));
                    assignment.assign(subject);
                    boolean result = recursiveAssign(pointer+1);
                    if(result)return result;
                    assignment.removeLast();
                    
                }   
                               
            }
            
            
        }
      return false;  
    }
    
    
    
}
