package edu.trial.itcompany.parser;

import edu.trial.itcompany.exceptions.ParserException;
import edu.trial.itcompany.model.Employee;
import edu.trial.itcompany.model.Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Parser {
    /**
     * text that will be parsed to list of employees with projects
     */
    private String data;

    /**
     * Method with rules to parse employees list
     * Parsing begins with this method
     * @return Array list of employees
     * @throws ParserException
     */
    private ArrayList<Employee> parseEmployeeList() throws ParserException{
        if(data.startsWith("[")){
            ArrayList<Employee> employees = new ArrayList<>();
            nextChar();
            while(!data.startsWith("]")&& !data.isEmpty()){
                employees.add(parseEmployee());
                if(data.startsWith(",")){
                    nextChar();
                }
            }
            if(!data.startsWith("]")){
                throw new ParserException("Missing ] at employees list end");
            }
            return employees;
        }
        else{
            throw new ParserException("Missing [ at employees list start");
        }
    }

    /**
     * Method with rules to parse one employee
     * @return Employee object with all fields set
     * @throws ParserException
     */
    private Employee parseEmployee()throws ParserException{
        if(data.startsWith("{")) {
            Employee employee = new Employee();
            nextChar();

            employee.setName(parseKeyValue("personName"));
            removeComaIfExists();
            employee.setDepartment(parseKeyValue("department"));
            removeComaIfExists();

            if(data.startsWith("\"projects\":")){
                data=data.substring(data.indexOf(':')+1);
                employee.setProjectList(parseProjectList());
            }
            else{
                throw new ParserException("Missing projects list at employee description");
            }

            if(data.startsWith("}")){
                nextChar();
            }
            else{
                throw new ParserException("Missing } at employee description end");
            }

            return employee;
        }
        else{
            throw new ParserException("Missing { at employee description start");
        }
    }

    /**
     * Method to parse key-value pair from employee or project description
     * @param key key string
     * @return value string
     * @throws ParserException
     */
    private String parseKeyValue(String key) throws ParserException{
        String value;
        if(data.startsWith("\""+key+"\":")){
            data=data.substring(data.indexOf(':')+1);
            if(data.startsWith("\"")) {
                nextChar();
                value=data.substring(0, data.indexOf("\""));
                data=data.substring(data.indexOf("\"")+1);
                return value;
            }
            else{
                throw new ParserException("Missing "+key+" value at employee description");
            }
        }
        else{
            throw new ParserException("Missing "+key+" at employee description");
        }
    }

    /**
     * Method with rules to parse projects list
     * @return Array list of projects
     * @throws ParserException
     */
    private ArrayList<Project> parseProjectList() throws ParserException{
        if(data.startsWith("[")){
            ArrayList<Project> projects = new ArrayList<>();
            nextChar();
            while(!data.startsWith("]") && !data.isEmpty()){
                projects.add(parseProject());
                if(data.startsWith(",")){
                    nextChar();
                }
            }
            if(data.startsWith("]")){
                nextChar();
            }
            else{
                throw new ParserException("Missing ] at projects list end");
            }
            return projects;
        }
        else{
            throw new ParserException("Missing [ at projects list start");
        }
    }

    /**
     * Method with rules to parse one project
     * @return Project object with all fields set
     * @throws ParserException
     */
    private Project parseProject() throws ParserException{
        if(data.startsWith("{")) {
            Project project = new Project();
            nextChar();

            project.setName(parseKeyValue("projectName"));
            removeComaIfExists();
            project.setCustomer(parseKeyValue("customer"));
            removeComaIfExists();
            project.setManager(parseKeyValue("manager"));

            if(data.startsWith("}")){
                nextChar();
            }
            else{
                throw new ParserException("Missing } at project description end");
            }

            return project;
        }
        else{
            throw new ParserException("Missing { at project description start");
        }
    }

    /**
     * removes one char from string beginning
     */
    private void nextChar() {
        data = data.substring(1);
    }

    private void removeComaIfExists(){
        if(data.startsWith(",")){
            nextChar();
        }
    }

    /**
     * Entry method
     * @param filePath path to file to be parsed
     * @return Array list of employees with all data about each employee and his projects
     */
    public ArrayList<Employee> parse(String filePath){
        data = "";

        try {
            Scanner in = new Scanner(new File(filePath));
            while (in.hasNext()) {
                data += in.nextLine();
            }
            in.close();
            data = data.replaceAll("\\s", ""); // remove whitespaces
            return parseEmployeeList();
        }
        catch(ParserException e){
            System.out.println("Error while parsing: "+e.getMessage());
        }
        catch(FileNotFoundException e){
            System.out.println("Failed to find file: "+e.getMessage());
        }
        return null;
    }
}
