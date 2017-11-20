package edu.trial.itcompany;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        File file = new File("D:\\Java\\NC\\nc-practice\\src\\main\\java\\base.dat");
        parser.parse(file);
    }
}
