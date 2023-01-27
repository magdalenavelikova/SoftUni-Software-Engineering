package bakery;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository
        Bakery bakery = new Bakery("Barny", 10);
//Initialize entity
        Employee employee = new Employee("Stephen", 40, "Bulgaria");
//Print Employee
        System.out.println(employee); //Employee: Stephen, 40 (Bulgaria)

//Add Employee
        bakery.add(employee);
//Remove Employee
        System.out.println(bakery.remove("Employee name")); //false

        Employee secondEmployee = new Employee("Mark", 34, "UK");

//Add Employee
        bakery.add(secondEmployee);

        Employee oldestEmployee = bakery.getOldestEmployee(); // Employee with name Stephen
        Employee employeeStephen = bakery.getEmployee("Stephen"); // Employee with name Stephen
        System.out.println(oldestEmployee); //Employee: Stephen, 40 (Bulgaria)
        System.out.println(employeeStephen); //Employee: Stephen, 40 (Bulgaria)

        System.out.println(bakery.getCount()); //2

        System.out.println(bakery.report());
//Employees working at Bakery Barny:
//Employee: Stephen, 40 (Bulgaria)
//Employee: Mark, 34 (UK)



    }
}
