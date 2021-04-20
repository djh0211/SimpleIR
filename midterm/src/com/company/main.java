package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String arg = args[0];
        if (arg.equals("-f")) {
            if (args.length > 2 && args[2].equals("-q")) {
                String txt_dir = args[1];
                String query = args[3];
                genSnippet searcher = new genSnippet();
                ArrayList<Double> sim = searcher.CalcSim(query, txt_dir);

            }
        }
    }
}
