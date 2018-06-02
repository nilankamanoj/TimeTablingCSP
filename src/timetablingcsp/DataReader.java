/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablingcsp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nilanka
 */
public class DataReader {
    
    public void readData(List<Subject> subjects, List<String> rooms) throws FileNotFoundException, IOException{
        List<String> lines = new ArrayList<String>();
        
        String everything = "";
        BufferedReader br = new BufferedReader(new FileReader("input.csv"));
try {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        lines.add(line.toString());
        line = br.readLine();
    }
    
} finally {
    br.close();
}
        for(int i = 0; i<lines.size()-1; i++){
            String[] stream = lines.get(i).split(",");
            Subject sub = new Subject();
            sub.setName(stream[0]);
            sub.setCompulsory(stream[1].equals("c"));
            for(int j = 2;j<stream.length ;j++){
                if(stream[j]!=null && stream[j]!=""){
                    sub.addPossibleTimeSlot(stream[j]);
                }
            }
            subjects.add(sub);
        }
        String rm[] = lines.get(lines.size()-1).split(",");
        for(int i =0; i<rm.length;i++){
            if(rm[i]!=null && rm[i]!=""){
                rooms.add(rm[i]);
            }
        }

    }
    
}
