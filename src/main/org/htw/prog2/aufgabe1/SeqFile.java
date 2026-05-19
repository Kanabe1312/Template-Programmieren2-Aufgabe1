package org.htw.prog2.aufgabe1;

import java.util.HashSet;

public class SeqFile {

    private HashSet<String> sequences = new HashSet<>();
    private boolean valid = false;
    private String fistSequence = "";

    public SeqFile(String filename) {
        valid = readFile(filename);
    }

    private boolean readFile(String filename) {
       try{
           java.io.File file = new java.io.File(filename);
           if(!file.exists()){
               return false;
           }
           java.util.Scanner scanner = new java.util.Scanner(file);
           StringBuilder seq = new StringBuilder();
           while(scanner.hasNextLine()){
               String line = scanner.nextLine().trim();

               if(line.isEmpty()){
                   continue;
               }
               if(line.startsWith(">")){
                   if(seq.length()>0){

                       addSequence(seq);
                       seq = new StringBuilder();
                   }
               }else{
                   seq.append(line);
               }
           }
          if(seq.length()>0){
              addSequence(seq);
          }
          scanner.close();

          return sequences.size() > 0;
       } catch (Exception e) {
           return false;
       }
    }






    private int addSequence(StringBuilder seq) {
        String s = seq.toString();

        sequences.add(s);

        if (sequences.size() == 1) {
            fistSequence = s;
        }

        return s.length();
    }

    public int getNumberOfSequences() {
        if(!valid){
            return 0;
        }
        return sequences.size();
    }


    public HashSet<String> getSequences() {
        if (!valid) {
            return new HashSet<>();
        }
        return sequences;
    }

    public String getFirstSequence() {
        if (!valid) {
            return "";
        }
        return fistSequence;
    }


    public boolean isValid() {
        return valid;
    }
}
