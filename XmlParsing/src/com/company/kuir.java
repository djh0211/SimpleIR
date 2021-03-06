package com.company;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class kuir {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ClassNotFoundException {

        String arg = args[0];
        if (arg.equals("-c")) {
            if (args[1] != null) {
                String dir = args[1];
                File path = new File(dir); // file list
                File[] fileList = path.listFiles();
                makeCollection mc = new makeCollection();
                mc.mkCollection(fileList);
            }
        } else if (arg.equals("-k")) {
            if (args[1] != null) {
                String collection_dir = args[1];
                File collection = new File(collection_dir);  // collection.xml
                makeKeyword mk = new makeKeyword();
                mk.mkword(collection);
            }
        } else if (arg.equals("-i")) {
            if (args[1] != null) {
                String index_dir = args[1];
                indexer ind = new indexer();
                ind.Hashmap(index_dir);
            }
        }else if(arg.equals("-s")) {
            if (args.length > 2 && args[2].equals("-q")) {
                String p_dir = args[1];
                String query = args[3];
                searcher searcher = new searcher();
                ArrayList<Double> sim = searcher.CalcSim(query, p_dir);

                searcher.printTitle(sim, "/Users/hadongjun/Documents/SimpleIR/collection.xml");

            }
        }


    }
}
