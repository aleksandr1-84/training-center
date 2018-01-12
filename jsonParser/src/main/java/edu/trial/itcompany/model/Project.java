package edu.trial.itcompany.model;

public class Project {
    private String name;
    private String customer;
    private String manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Project(){

    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", customer='" + customer + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
