package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private List<Employee> data;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee) {
        if (data.size() < capacity) {
            data.add(employee);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return data.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);

    }

    public Employee getEmployee(String name) {
        return data.stream().filter(e -> e.getName().equals(name)).findAny().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Employees working at Bakery %s:",this.name));

        for (Employee employee : data) {
            output.append(System.lineSeparator());
            output.append(employee.toString());
        }
        return output.toString();

    }
}
