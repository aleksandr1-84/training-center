package edu.trial.itcompany;

import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InformationRecipientImpl implements InformationRecipient {


    private String path;

    public InformationRecipientImpl(String path) {
        this.path = path;
    }

    @Override
    public List<String> getListOfEmployeeOnProject(String project) {
        Scanner sourceData = null;
        try {
            sourceData = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> res = new ArrayList<>();
        List<Employee> employees = JsonParser.parse(sourceData);
        for (Employee e : employees) {
            List<Project> projects = e.getProjects();
            for (Project p : projects) {
                if (p.getProjectName().equals(project)) {
                    res.add(e.getName());
                }
            }
        }
        return res;


    }

    @Override
    public List<String> getListOfManagersForEmployee(String empName) {
        Scanner sourceData = null;
        try {
            sourceData = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> res = new ArrayList<>();
        List<Employee> employees = JsonParser.parse(sourceData);
        for (Employee e : employees) {
            if (e.getName().equals(empName)) {
                for (Project p : e.getProjects()) {
                    res.add(p.getManager().getName());
                }
            }
        }
        return res;
    }

    @Override
    public List<String> getListOfNotBusyEmployees() {
        Scanner sourceData = null;
        try {
            sourceData = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> res = new ArrayList<>();
        for (Employee e : JsonParser.parse(sourceData)) {
            if (e.getProjects().size() == 0) {
                res.add(e.getName());
            }
        }
        return res;
    }

    @Override
    public List<String> getListOfProjectsForCustomer(String customerName) {
        Scanner sourceData = null;
        try {
            sourceData = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean isPresent = false;
        List<String> res = new ArrayList<>();
        List<Employee> employees = JsonParser.parse(sourceData);
        for (Employee e : employees) {
            List<Project> projects = e.getProjects();
            for (Project p : projects) {
                if (p.getCustomer().equals(customerName)) {
                    for(String s : res){
                        if(s.equals(p.getProjectName())) {
                            isPresent = true;
                        }
                    }
                    if(!isPresent)
                        res.add(p.getProjectName());
                }
                isPresent = false;
            }

        }
        return res;
    }
}
