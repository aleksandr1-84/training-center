package edu.trial.itcompany;

import java.util.LinkedList;
import java.util.List;

public class InformationRecipientImpl implements InformationRecipient{
    private List<Person> personList = new LinkedList<>();

    @Override
    public List<String> getListOfEmployeeOnProject(String project) {
        List<String> list = new LinkedList<>();
        for (Person person:personList) {
            for (Project project1:person.getProjects()) {
                if (project.equals(project1.getName())){
                    list.add(person.getName());
                }
            }
        }
        return list;
    }

    @Override
    public List<String> getListOfManagersForEmployee(String empName) {
        List<String> list = new LinkedList<>();
        for (Person person:personList) {
            if (empName.equals(person.getName()))
                for (Project project1 : person.getProjects()) {
                    String manager = project1.getManager();
                    if (!empName.equals(manager)&&!list.contains(manager)) {
                        list.add(manager);
                    }
                }
        }
        return list;
    }

    @Override
    public List<String> getListOfNotBusyEmployees() {
        List<String> list = new LinkedList<>();
        for (Person person:personList) {
            if (person.getProjects().isEmpty()) {
                list.add(person.getName());
            }
        }
        return list;
    }

    @Override
    public List<String> getListOfProjectsForCustomer(String customerName) {
        List<String> list = new LinkedList<>();
        for (Person person:personList) {
            for (Project project1:person.getProjects()) {
                if (customerName.equals(project1.getCustomer())&&!list.contains(project1.getName())){
                    list.add(project1.getName());
                }
            }
        }
        return list;
    }

    public void addPerson(Person person)
    {
        personList.add(person);
    }
}
