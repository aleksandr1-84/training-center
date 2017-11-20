package edu.trial.itcompany;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    List<String> list = new ArrayList<>();
    String line = null;

    public void parse(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
