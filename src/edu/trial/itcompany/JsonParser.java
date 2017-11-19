package edu.trial.itcompany;

import org.omg.CORBA.MARSHAL;

import java.util.*;

public class JsonParser {

    public static List<Employee> parse(Scanner sc) {
        Stack<String> stringStack = new Stack<>();
        List<Employee> employeeList = new ArrayList<>();
        Employee empl = new Employee();
        Project project = new Project();
        List<Project> projects = new ArrayList<>();
        boolean isProject = false;
        String s;
        while (sc.hasNextLine()) {
            s = sc.nextLine().trim();
            switch (s) {
                case "{":
                    if (stringStack.peek().equals("},")) {
                        if (isProject) {
                            projects.add(project);
                            project = new Project();
                        } else {
                            employeeList.add(empl);
                            empl = new Employee();
                        }
                        stringStack.pop();
                    }
                    stringStack.push("{");
                    break;

                case "}":
                    if (stringStack.peek().equals("{")) {
                        if (!isProject){
                            empl.setProjects(projects);
                            employeeList.add(empl);
                            empl = new Employee();
                        }
                        stringStack.pop();
                    }

                    break;

                case "},":
                    if (stringStack.peek().equals("{")) {
                        if (isProject){
                            projects.add(project);
                            project = new Project();
                        }
                        else {
                            empl.setProjects(projects);
                            projects = new ArrayList<>();
                            employeeList.add(empl);
                            empl = new Employee();
                        }
                        stringStack.pop();
                    }
                    break;

                case "[":
                    if (!stringStack.empty()) {
                        isProject = true;
                    }
                    stringStack.push("[");
                    break;

                case "]":
                    if (isProject) {
                        projects.add(project);
                        project = new Project();
                        isProject = false;
                    }
                    stringStack.pop();
                    break;
                default:
                    String[] line = s.split(":");
                    line[1] = line[1].replace("\"","");
                    line[1] = line[1].replace(",","");
                    line[1] = line[1].trim();
                    if (line[0].matches("\"personName(.*)")) {
                        empl.setName(line[1]);
                    }
                    if (line[0].matches("\"department(.*)")) {
                        empl.setDepartment(line[1]);
                    }

                    if (line[0].matches("\"projectName(.*)")) {
                        project.setProjectName(line[1]);
                    }

                    if (line[0].matches("\"customer(.*)")) {
                        project.setCustomer(line[1]);
                    }

                    if (line[0].matches("\"manager(.*)")) {
                        project.setManager(new Employee(line[1], "", null));
                    }
                    if (line[0].matches("\"projects(.*)")) {
                        if (line[1].trim().equals("[]")) {
                            isProject = false;
                        }
                        else
                        {
                            isProject = true;
                            stringStack.push(line[1]);
                        }
                    }
            }
        }
        sc.reset();
        return employeeList;
    }
}
