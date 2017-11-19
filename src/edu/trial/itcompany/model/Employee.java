package edu.trial.itcompany.model;

import java.util.ArrayList;

public class Employee {
    private String name;
    private String Department;
    private ArrayList<Project> projectList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public ArrayList<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(ArrayList<Project> projectList) {
        this.projectList = projectList;
    }

    public Employee(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Department='" + Department + '\'' +
                ", projectList=" + projectList +
                '}';
    }
}
