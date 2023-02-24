package objectsAndClassesMoreExercise.companyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList=new ArrayList<>();

    Department(){

    }
    public Department(String name,Employee employee ) {
        this.name = name;
        employeeList.add(employee);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeToList(Employee employee) {
        this.employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void  printSortedDescendingBySalary() {
        this.employeeList.stream().sorted((e1,e2)->Double.compare(e2.getSalary(), e1.getSalary())
                ).forEach(e -> System.out.println(e.toString()));

    }
}
