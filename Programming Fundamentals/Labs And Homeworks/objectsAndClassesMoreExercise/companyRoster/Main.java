package objectsAndClassesMoreExercise.companyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            String inputLine = scanner.nextLine();
            String[] command = inputLine.split("\\s+");
            Employee currentEmployee = new Employee();

            if (command.length == 6) {
                currentEmployee = new Employee(
                        command[0],
                        Double.parseDouble(command[1]),
                        command[2],
                        command[3],
                        command[4],
                        Integer.parseInt(command[5]));
            } else if (command.length == 5) {
                if (isInteger(command[command.length - 1])) {
                    currentEmployee = new Employee(
                            command[0],
                            Double.parseDouble(command[1]),
                            command[2],
                            command[3],
                            "n/a",
                            Integer.parseInt(command[4]));
                } else {
                    currentEmployee = new Employee(
                            command[0],
                            Double.parseDouble(command[1]),
                            command[2],
                            command[3],
                            command[4],
                            -1);
                }

            } else if (command.length == 4) {
                currentEmployee = new Employee(
                        command[0],
                        Double.parseDouble(command[1]),
                        command[2],
                        command[3],
                        "n/a",
                        -1);
            }


            Department department = new Department(command[3], currentEmployee);
            if (!isDepartmentExist(departments, command[3])) {
                departments.add(department);
            } else {
                for (Department dp : departments) {
                    if (dp.getName().equals(command[3])) {
                        dp.setEmployeeToList(currentEmployee);
                        break;
                    }
                }
            }
        }
        double maxAverageSalary = Double.MIN_VALUE;
        String departmentName = "";
        for (Department dp : departments) {
            double averageSalary = getAverageSalary(dp);
            if (averageSalary > maxAverageSalary) {
                maxAverageSalary = averageSalary;
                departmentName = dp.getName();
            }
        }


        System.out.println("Highest Average Salary: " + departmentName);
        for (Department dp : departments) {
            if (dp.getName().equals(departmentName)) {
                dp.printSortedDescendingBySalary();
            }
        }
    }

    public static boolean isInteger(String input) {
        Pattern pattern = Pattern.compile("[+-]?[0-9][0-9]*");
        return pattern.matcher(input).matches();
    }

    public static boolean isDepartmentExist(List<Department> departments, String name) {
        for (Department dp : departments) {
            if (dp.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static double getAverageSalary(Department department) {
        double averageSalary = 0;

        for (Employee employee : department.getEmployeeList()) {
            averageSalary += employee.getSalary();
        }
        averageSalary = averageSalary / department.getEmployeeList().size();
        return averageSalary;
    }
}
