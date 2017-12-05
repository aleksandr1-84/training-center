package edu.trial.itcompany;

import java.util.ArrayList;
import java.util.List;

public class InformationRecipientImpl implements InformationRecipient {

    List<Person> listOfPersons = new ArrayList<Person>() {
    };

    InformationRecipientImpl(List<Person> listOfPersons) {
       this.listOfPersons = listOfPersons;
    }

    public List<String> getListOfEmployeeOnProject(String project) {
        List<String> listOfEmployeeOnProject = new ArrayList<>();
        for (Person person : listOfPersons) {
            if (person.getProjects().size() > 0) {
                for (Project project1 : person.getProjects()) {
                    if (project1.getProjectName().equals(project)) {
                        listOfEmployeeOnProject.add(person.getPersonName());
                    }
                }
            }
        }
        return listOfEmployeeOnProject;
    }

    public List<String> getListOfManagersForEmployee(String empName) {
        List<String> listOfManagersForEmployeeOnProject = new ArrayList<>();
        for (Person person : listOfPersons) {
            if (person.getPersonName().equals(empName) && !person.getDepartment().equals("Manager")) {
                for (Project project1 : person.getProjects()) {
                    if (!listOfManagersForEmployeeOnProject.contains(project1.getManager())) {
                        listOfManagersForEmployeeOnProject.add(project1.getManager());
                    }
                }
            }
        }
        return listOfManagersForEmployeeOnProject;
    }

    public List<String> getListOfNotBusyEmployees() {
        List<String> listOfNotBusyEmployees = new ArrayList<>();
        for (Person person : listOfPersons) {
            if (person.getProjects().size() == 0) {
                        listOfNotBusyEmployees.add(person.getPersonName());
                    }
                }
        return listOfNotBusyEmployees;
    }

    public List<String> getListOfProjectsForCustomer(String customerName) {
        List<String> listOfProjectsForCustomer = new ArrayList<>();
        for (Person person : listOfPersons) {
            if (person.getProjects().size() > 0) {
                for (Project project1 : person.getProjects()) {
                    if (project1.getCustomer().equals(customerName) && !listOfProjectsForCustomer.contains(project1.getProjectName())) {
                        listOfProjectsForCustomer.add(project1.getProjectName());
                    }
                }
            }
        }
        return listOfProjectsForCustomer;
    }
}
