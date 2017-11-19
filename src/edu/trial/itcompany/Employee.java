package edu.trial.itcompany;

import java.util.List;

public class Employee {
    private String name;
    private String department;
    private List<Project> projects;

    public Employee(){};

    public Employee(String name, String department, List<Project> projects) {
        this.name = name;
        this.department = department;
        this.projects = projects;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!name.equals(employee.name)) return false;
        if (!department.equals(employee.department)) return false;
        return projects != null ? projects.equals(employee.projects) : employee.projects == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + (projects != null ? projects.hashCode() : 0);
        return result;
    }
}
