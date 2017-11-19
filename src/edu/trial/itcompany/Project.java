package edu.trial.itcompany;

public class Project {

    private String projectName;
    private String customer;
    private Employee manager;


    public Project(){}

    public Project(String projectName, String customer, Employee manager) {
        this.projectName = projectName;
        this.customer = customer;
        this.manager = manager;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!projectName.equals(project.projectName)) return false;
        if (!customer.equals(project.customer)) return false;
        return manager.equals(project.manager);
    }

    @Override
    public int hashCode() {
        int result = projectName.hashCode();
        result = 31 * result + customer.hashCode();
        result = 31 * result + manager.hashCode();
        return result;
    }
}
