package edu.trial.itcompany;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        InformationRecipient ir = new InformationRecipientImpl("base.dat");
        List<String> oo = ir.getListOfEmployeeOnProject("Dos");
        List<String> aa = ir.getListOfManagersForEmployee("Sviridin");
        List<String> bb = ir.getListOfNotBusyEmployees();
        List<String> cc = ir.getListOfProjectsForCustomer("Microsoft");
        System.out.println("");
    }
}
