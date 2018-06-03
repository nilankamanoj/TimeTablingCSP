/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablingcsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        String input;
        String output;
        if (args.length == 0) {
            Scanner reader = new Scanner(System.in);
            while (true) {
                System.out.println("Enter input file name: ");
                input = reader.next();
                System.out.println("Enter output file name: ");
                output = reader.next();
                if ((input.endsWith(".csv") || input.endsWith(".csv"))
                        && (output.endsWith(".csv") || output.endsWith(".csv"))) {
                    break;
                } else {
                    System.out.println("wrong file types!");
                }
            }
            reader.close();
        }

        else {
            input = args[0];
            output = args[1];
        }
        if ((input.endsWith(".csv") || input.endsWith(".csv"))
                && (output.endsWith(".csv") || output.endsWith(".csv"))) {
            assignment = new Assignment();
            DataHandler dr = new DataHandler();
            dr.readData(subjects, rooms, input);
            boolean out = recursiveAssign(0);
            if (out) {
                List<Subject> subs = assignment.getSubjects();
                dr.writeData(subs, output);
                System.out.println("done scheduling!");
            } else {
                System.out.println("cannot schedule!!");
            }
        } else {
            System.out.println("wrong file types!");
        }
    }

    private static boolean recursiveAssign(int pointer) {

        if (subjects.size() == pointer)
            return true;
        Subject subject = subjects.get(pointer);
        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < subject.getPossibleTimeSlots().size(); j++) {
                if (assignment.validate(subject.getPossibleTimeSlots().get(j), rooms.get(i), subject.isCompulsory())) {
                    subject.setRoom(rooms.get(i));
                    subject.setTimeSlot(subject.getPossibleTimeSlots().get(j));
                    assignment.assign(subject);
                    boolean result = recursiveAssign(pointer + 1);
                    if (result)
                        return result;
                    assignment.removeLast();

                }

            }

        }
        return false;
    }

}
