package examPreparation.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);

    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findAny().orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Employees working at Bakery %s:", this.name));

        for (Employee employee : employees) {
            output.append(System.lineSeparator());
            output.append(employee.toString());
        }
        return output.toString();

    }
}
