package dependencyInjection;

import dependencyInjection.model.Employee;
import dependencyInjection.model.EmployeeContainer;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Properties;

public class ComparatorSetter {
    /**
     * Injects comparator according to config file
     * @param container object where comparator will be injected
     * @throws Exception
     */
    public static void setComparator(EmployeeContainer container) throws Exception {
        //get property name from config file
        String property = "get" + firstUpperCase(getSorterPropertyName());

        //try to find method with such name
        Method method = Employee.class.getMethod(property);

        for (Field field : container.getClass().getDeclaredFields()) {
            //if field has 'injectable' annotation
            if (field.getAnnotation(Injectable.class) != null) {
                //create new comparator
                Comparator<Employee> comparator = new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        try {
                            return ((Comparable) method.invoke(o1)).compareTo(method.invoke(o2));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            return 0;
                        }
                    }
                };

                //set new comparator
                field.set(container, comparator);
            }
        }
    }

    /**
     * Get name of sort type from config file
     * @return property value
     * @throws Exception
     */
    private static String getSorterPropertyName() throws Exception {
        Properties prop = new Properties();
        InputStream input = null;

        String filename = "config.properties";
        input = ComparatorSetter.class.getClassLoader().getResourceAsStream(filename);
        prop.load(input);

        String sortType = prop.getProperty("sorter");

        input.close();
        return sortType;
    }

    /**
     * Make the beginning of a string with upper case
     * @param word string to be modified
     * @return
     */
    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
