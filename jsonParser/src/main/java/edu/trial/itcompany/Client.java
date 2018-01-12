package edu.trial.itcompany;
import edu.trial.itcompany.parser.*;

public class Client {
    public static void main(String[] args){
        InformationRecipientImpl repository= new InformationRecipientImpl();

        System.out.println("Testing implementation...");
        System.out.println("\nList of all employees:");
        System.out.println(repository.getEmployeeList());

        System.out.println("\nList of employees on project '4G':");
        System.out.println(repository.getListOfEmployeeOnProject("4G"));

        System.out.println("\nList of managers for employee 'Jobs':");
        System.out.println(repository.getListOfManagersForEmployee("Jobs"));

        System.out.println("\nList of not busy employees:");
        System.out.println(repository.getListOfNotBusyEmployees());

        System.out.println("\nList of projects for customer 'Microsoft':");
        System.out.println(repository.getListOfProjectsForCustomer("Microsoft"));
    }
}
