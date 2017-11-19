package edu.trial.itcompany;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.trial.itcompany.model.*;
import edu.trial.itcompany.parser.Parser;

public class InformationRecipientImpl implements InformationRecipient{
    private ArrayList<Employee> employeeList;

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<String> getListOfEmployeeOnProject(String project) {
        List<String> employees =new ArrayList<>();
        for(Employee emp: employeeList){
            if(emp.getProjectList().stream().anyMatch(proj->proj.getName().equals(project))){
                employees.add(emp.getName());
            }
        }
        return employees;
    }

    public List<String> getListOfManagersForEmployee(String empName){
        List<String> managers =new ArrayList<>();
        Optional<Employee> empl = employeeList.stream().filter(emp->emp.getName().equals(empName)).findFirst();

        if(!empl.isPresent()) // if there is no such name in list, it will return empty list
            return managers;

        empl.get().getProjectList().forEach(proj->managers.add(proj.getManager()));
        return managers;
    }

    public List<String> getListOfNotBusyEmployees() {
        List<String> employees=new ArrayList<>();
        for(Employee emp: employeeList){
            if(emp.getProjectList().isEmpty()){
                employees.add(emp.getName());
            }
        }
        return employees;
    }

    public List<String> getListOfProjectsForCustomer(String customerName) {
        List<String> projects = new ArrayList<>();
        for(Employee emp: employeeList){
            for(Project proj: emp.getProjectList()){
                if(proj.getCustomer().equals(customerName)){
                    projects.add(proj.getName());
                }
            }
        }
        return projects;
    }

    public InformationRecipientImpl(){
        Parser parser = new Parser();
        employeeList = parser.parse("base.dat");
    }
}
