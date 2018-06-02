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
public class Assignment {
    private List<Subject> subjects = new ArrayList<Subject>();

    public List<Subject> getSubjects() {
        return subjects;
    }

    public boolean validate(String timeSlot, String room, boolean compulsory) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).isCompulsory() && subjects.get(i).getTimeSlot().equals(timeSlot)) {
                return false;
            }
            if (!subjects.get(i).isCompulsory() && subjects.get(i).getTimeSlot().equals(timeSlot) && compulsory) {
                return false;
            } else if (!subjects.get(i).isCompulsory() && subjects.get(i).used(room, timeSlot)) {
                return false;
            }
        }
        return true;
    }

    public void assign(Subject subject) {
        this.subjects.add(subject);
    }

    public void removeLast() {
        this.subjects.remove(subjects.size() - 1);
    }

    public int getCount() {
        return this.subjects.size();
    }

}
