package dependencyInjection.model;

import dependencyInjection.Injectable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeContainer {
    public List<Employee> employees = new ArrayList<Employee>();

    //Annotation will let comparator setter to find this field
    @Injectable
    public Comparator<Employee> comparator;

    public void add(Employee emp){
        employees.add(emp);
    }

    public void delete(Employee emp){
        employees.remove(emp);
    }

    public Employee get(int id){
        return employees.get(id);
    }

    public void sort(){
        employees.sort(comparator);
    }

    @Override
    public String toString() {
        String str="";
        for(Employee emp:employees){
            str+=emp.toString()+'\n';
        }
        return str;
    }
}
