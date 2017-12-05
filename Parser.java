package edu.trial.itcompany;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    List<Person> listOfPersons = new ArrayList<>();
    List<String> list = new ArrayList<>();
    String readedLine = null;
    StringBuffer line = new StringBuffer();
    int index1;
    int index2;
    int index3;
    int index4;
    String subline = null;

    public List<Person> parse(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((readedLine = reader.readLine()) != null) {
                list.add(readedLine);
            }
            reader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        for(String s : list) {
            line.append(s);
        }

        index1 = line.indexOf("{");
        index2 = line.indexOf("]", index1);
        index3 = line.indexOf("}", index2);
        while (index1 != -1) {
            listOfPersons.add(personAdder(index1));
            index1 = line.indexOf("{", index3);
            index2 = line.indexOf("]", index1);
            index3 = line.indexOf("}", index2);
        }
        return listOfPersons;
    }

    private Person personAdder(int index) {

        subline = line.substring(index, index3);

        index4 = subline.indexOf("personName");
        Person person = new Person();
        person.setPersonName(setter(index4));

        index4 = subline.indexOf("department");
        person.setDepartment(setter(index4));

        index4 = subline.indexOf("projects");

        if ((subline.indexOf("]", index4) - subline.indexOf("[", index4)) > 1) {
            while (index4 != -1) {
                person.addProjects(projectAdder(index4));
                index4 = subline.indexOf("projectName", subline.indexOf("manager", index4));
            }
        }
        return person;
    }

    private Project projectAdder(int index) {
        Project project = new Project();
        index = subline.indexOf("projectName", index);
        project.setProjectName(setter(index));

        index = subline.indexOf("customer", index);
        project.setCustomer(setter(index));

        index = subline.indexOf("manager", index);
        project.setManager(setter(index));

        return project;
    }

    private String setter(int index) {
        int index5 = subline.indexOf(":", index);
        int index6 = subline.indexOf("\"", index5);
        int index7 = subline.indexOf("\"", index6 + 1);
        return subline.substring(index6 + 1, index7);
    }
}
