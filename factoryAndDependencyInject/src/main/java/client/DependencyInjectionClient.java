package client;

import dependencyInjection.ComparatorSetter;
import dependencyInjection.model.EmployeeContainer;
import dependencyInjection.model.Employee;

public class DependencyInjectionClient {
    public static void main(String[] args){
        EmployeeContainer container = new EmployeeContainer();
        container.add(new Employee("Steve", "Apple", 40));
        container.add(new Employee("Michael", "Microsoft", 25));
        container.add(new Employee("Paul", "Google", 30));
        container.add(new Employee("George", "Netcracker", 28));

        try {
            //Dependency injection
            //Sort comparator will be injected from config file
            ComparatorSetter.setComparator(container);

            System.out.println("Employees: \n");
            System.out.println(container.toString());

            System.out.println("\nSorting...\n");
            container.sort();
            System.out.println(container.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
