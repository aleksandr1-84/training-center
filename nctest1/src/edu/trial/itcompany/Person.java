package edu.trial.itcompany;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private String department;
    public List<Project> projectList = new LinkedList<>();

    public Person(String name, String department)
    {
        this.name=name;
        this.department=department;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addProject(Project project)
    {
        projectList.add(project);
    }

    public List<Project> getProjects(){
        return projectList;
    }
}
