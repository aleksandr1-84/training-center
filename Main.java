package edu.trial.itcompany;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        File file = new File("D:\\Java\\NC\\nc-practice\\src\\main\\java\\base.dat");
        List<Person> personList = parser.parse(file);

        System.out.println(personList.size());

        for (Person person : personList) {
            System.out.println("Имя : " + person.getPersonName());
            System.out.println("Департамент : " + person.getDepartment());
            System.out.println("Проектов : " + person.getProjects().size());
            if (person.getProjects().size() > 0) {
                for (Project project : person.getProjects()) {
                    System.out.println("Название проекта : " + project.getProjectName());
                    System.out.println("Заказчик проекта : " + project.getCustomer());
                    System.out.println("Менеджер проекта : " + project.getManager());
                }
            }
        }

        InformationRecipientImpl info = new InformationRecipientImpl(personList);
        List<String> personNames = info.getListOfEmployeeOnProject("Kursovoi");
        System.out.println(personNames.size());
        for (String personName : personNames) {
            System.out.println(personName);
        }

        List<String> personManagers = info.getListOfManagersForEmployee("Surname5");
        System.out.println(personManagers.size());
        for (String personManager : personManagers) {
            System.out.println(personManager);
        }

        List<String> listOfNotBusyEmployees = info.getListOfNotBusyEmployees();
        System.out.println(listOfNotBusyEmployees.size());
        for (String notBusyPerson : listOfNotBusyEmployees) {
            System.out.println(notBusyPerson);
        }

        List<String> listOfProjectsForCustomer = info.getListOfProjectsForCustomer("Oracle");
        System.out.println(listOfProjectsForCustomer.size());
        for (String projectForCustomer : listOfProjectsForCustomer) {
            System.out.println(projectForCustomer);
        }
    }
}
