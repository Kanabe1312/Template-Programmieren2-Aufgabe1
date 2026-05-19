package org.htw.prog2.aufgabe1;
import org.apache.commons.cli.*;

public class HIVDiagnostics {
    public static CommandLine parseOptions(String[] args) {
        try{
            Options options = new Options();

            options.addOption("m", "mutationfiles", true, "Mutation file");
            options.addOption("d", "drugnames", true, "Drug name");
            options.addOption("r", "references", true, "Reference fasta");
            options.addOption("p", "patientseqs", true, "Patient fasta");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options,args);

            if(!cmd.hasOption("m") || !cmd.hasOption("d")|| !cmd.hasOption("r") || !cmd.hasOption("r")
                    || !cmd.hasOption("p")){
                HelpFormatter formatter = new HelpFormatter();

                formatter.printHelp("HIVDiagnostics",options);
                return null;
            }
            return cmd;
        }catch(Exception e){
            HelpFormatter formatter = new HelpFormatter();

            formatter.printHelp("HIVDiagnostics",new Options());
            return null;
        }
    }

    public static void main(String[] args) {
    }
}
