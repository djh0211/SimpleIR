package com.company;

import org.snu.ids.kkma.index.Keyword;
import org.snu.ids.kkma.index.KeywordExtractor;
import org.snu.ids.kkma.index.KeywordList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class genSnippet {
    public ArrayList<Double> CalcSim(String query, String post_dir) throws IOException, ClassNotFoundException {
        KeywordExtractor ke = new KeywordExtractor();
        KeywordList kl = ke.extractKeyword(query, true);

        FileInputStream fileInputStream = new FileInputStream(post_dir);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object object = objectInputStream.readObject();
        objectInputStream.close();

        HashMap<String, ArrayList<String>> hashMap = (HashMap) object;

        HashMap<String, String> map_word = new HashMap<>();
        for (Keyword kw : kl) {
            String[] split_value = hashMap.get(kw.getString()).toString().replace("[", "").replace("]", "").split(" ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < split_value.length; i += 2) {
                int index = Integer.parseInt(split_value[i]);
                double weight = Double.parseDouble(split_value[i + 1]);
                for (int j = 0; j < 5; j++) {
                    if (index == j)
                        sb.append(j + ":" + weight + ";");
                    else sb.append(j + ":0;");
                }
//                System.out.println(sb);
            }
            map_word.put(kw.getString(), kw.getCnt() + "/" + sb);
        }

        HashMap<Integer, String> result = new HashMap<>();
        for (int id = 0; id < 5; id++) {
            double inner_product = 0.0;
            for (String key : map_word.keySet()) {
                String[] split_tf = map_word.get(key).split("/");
                double tf = Double.parseDouble(split_tf[0]);
                String[] split_value = split_tf[1].split(";");
                double weight = Double.parseDouble(split_value[id].split(":")[1]);

                inner_product += tf * weight;
            }
            result.put(id, String.format("%.2f", inner_product));
        }

        ArrayList<Double> sim = new ArrayList<>();
        for (int id : result.keySet()) {
            System.out.println("문서"+id+":"+result.get(id));
            sim.add(Double.parseDouble(result.get(id)));
        }
        return sim;
    }


}
