import edu.trial.itcompany.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File file = new File("base.dat");
        InformationRecipientImpl informationRecipientImpl = new InformationRecipientImpl();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String string;
                do {
                    string = scanner.nextLine();
                } while (scanner.hasNextLine() && !string.contains("personName"));
                if(scanner.hasNextLine()) {
                    String name = string.substring(string.indexOf(": ")+3, string.length()-2);
                    string = scanner.nextLine();
                    String department = string.substring(string.indexOf(": ")+3, string.length()-2);
                    Person person = new Person(name,department);
                    string = scanner.nextLine();
                    if (!string.contains("]")) {
                        do {
                            do {
                                string = scanner.nextLine();
                            } while (!string.contains("projectName") && !string.contains("]"));
                            if (string.contains("projectName")) {
                                String prName = string.substring(string.indexOf(": ") + 3, string.length() - 2);
                                string = scanner.nextLine();
                                String customer = string.substring(string.indexOf(": ") + 3, string.length() - 2);
                                string = scanner.nextLine();
                                String manager = string.substring(string.indexOf(": ") + 3, string.length() - 1);
                                Project project = new Project(prName, customer, manager);
                                person.addProject(project);
                            }
                        }while (!string.contains("]"));
                    }
                    informationRecipientImpl.addPerson(person);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        /*
        System.out.println("People who works with Project 4G:");
        List<String> list = informationRecipientImpl.getListOfEmployeeOnProject("4G");
        for(String string: list){
            System.out.println(string);
        }

        System.out.println("\nManagers of Minakov:");
        list = informationRecipientImpl.getListOfManagersForEmployee("Minakov");
        for(String string: list){
            System.out.println(string);
        }

        System.out.println("\nList of not busy InformationRecipientImpl:");
        list = informationRecipientImpl.getListOfNotBusyEmployees();
        for (String string: list){
            System.out.println(string);
        }

        System.out.println("\nList of projects of customer Megafon:");
        list = informationRecipientImpl.getListOfProjectsForCustomer("Megafon");
        for(String string:list) {
            System.out.println(string);
        }
        */
    }
}
