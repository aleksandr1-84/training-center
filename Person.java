package edu.trial.itcompany;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String personName;
    private String department;
    private List<Project> projects = new ArrayList<>();

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProjects(Project project) {
        this.projects.add(project);
    }
}
