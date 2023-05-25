package core;

import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
    }

    public void run() {
        System.out.println("Select Task /2-13/:");

        try {
            int command = Integer.parseInt(bufferedReader.readLine());
            switch (command) {
                case 2 -> task2();
                case 3 -> task3();
                case 4 -> task4();
                case 5 -> task5();
                case 6 -> task6();
                case 7 -> task7();
                case 8 -> task8();
                case 9 -> task9();
                case 10 -> task10();
                case 11 -> task11();
                case 12 -> task12();
                case 13 -> task13();
                default -> System.out.println("No such task!");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void task13() throws IOException {
        System.out.println("Enter town: ");
        String townName = bufferedReader.readLine();
        Town town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name=:p_town", Town.class)
                .setParameter("p_town", townName)
                .getSingleResult();
        entityManager.getTransaction().begin();

        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.town.id=:p_id", Address.class)
                .setParameter("p_id", town.getId())
                .getResultList();
        addresses.forEach(entityManager::remove);

        entityManager.remove(town);
        entityManager.getTransaction().commit();
        System.out.printf("%d address in %s deleted", addresses.size(), townName);
    }

    private void task12() {
        /*first way
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT  d.name, MAX(e.salary) from  departments as d join employees e on d.department_id = e.department_id\n" +
                "GROUP BY d.name\n" +
                "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000;").getResultList();
        resultList.forEach(r-> System.out.println(r[0]+" "+r[1]));*/

        List<Object[]> resultList = entityManager.createQuery("SELECT e.department.name, MAX (e.salary)  FROM Employee e GROUP BY e.department.name HAVING MAX (e.salary)  NOT BETWEEN 30000 AND 70000").getResultList();
        resultList.forEach(r -> System.out.println(r[0] + " " + r[1]));
    }

    private void task11() throws IOException {
        System.out.println("Enter pattern: ");
        String pattern = bufferedReader.readLine();
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee  e WHERE e.firstName LIKE :patternIn", Employee.class)
                .setParameter("patternIn", pattern.concat("%")).getResultList();

        employees.forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary()));
    }

    private void task10() {
        entityManager.getTransaction().begin();
        int count = entityManager.createQuery("UPDATE Employee e SET e.salary=e.salary*1.12 WHERE e.department.id IN :ids")
                .setParameter("ids", Arrays.asList(1, 2, 4, 11)).executeUpdate();
        entityManager.getTransaction().commit();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee  e WHERE e.department.id IN :ids", Employee.class)
                .setParameter("ids", Arrays.asList(1, 2, 4, 11)).getResultList();
        employees.forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));
    }

    private void task9() {
        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC ", Project.class)
                .setMaxResults(10)
                .getResultList();

        projects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.printf("Project name: %s%n", p.getName());
                    System.out.printf(" \tProject Description: %s%n", p.getDescription());
                    System.out.printf(" \tProject Start Date:%s%n", p.getStartDate());
                    System.out.printf(" \tProject End Date:%s%n", p.getEndDate());

                });

    }

    private void task8() throws IOException {
        System.out.println("Enter employee id: ");
        int id = Integer.parseInt(bufferedReader.readLine());
        Employee employee = entityManager.find(Employee.class, id);

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        employee.getProjects().stream()
                .map(Project::getName)
                .sorted(String::compareTo)
                .forEach(p -> System.out.printf("\t%s%n", p));
    }

    private void task7() {
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address  a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.stream()
                .forEach(a -> System.out.printf("%s, %s - %d employees%n",
                        a.getText(),
                        a.getTown() == null ? "Unknown" : a.getTown().getName(),
                        a.getEmployees().size()));

    }

    private void task6() throws IOException {
        System.out.println("Enter employee last name:");
        String lastName = bufferedReader.readLine();
        Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.lastName=:lName", Employee.class)
                .setParameter("lName", lastName).getSingleResult();
        Address address = createAddress("Vitoshka 15");
        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();

    }

    private Address createAddress(String addressString) {
        Address address = new Address();
        address.setText(addressString);
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private void task5() {

        entityManager.createQuery("SELECT e FROM Employee e  WHERE e.department.name=:dName ORDER BY e.salary, e.id", Employee.class)
                .setParameter("dName", "Research and Development")
                .getResultList()
                .stream()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getDepartment().getName(),
                        e.getSalary()));
    }

    private void task4() {
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.salary > :minSalary", Employee.class)
                .setParameter("minSalary", BigDecimal.valueOf(50000L))
                .getResultList().stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);

    }

    private void task3() throws IOException {
        System.out.println("Enter employee name: ");
        String employeeName = bufferedReader.readLine();
        String firstName = employeeName.split("\\s+")[0];
        String lastName = employeeName.split("\\s+")[1];

        List<Employee> employeeList = entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName=:fName AND e.lastName=:lName", Employee.class)
                .setParameter("fName", firstName)
                .setParameter("lName", lastName).getResultList();

        System.out.println(employeeList.isEmpty() ? "No" : "Yes");


    }

    private void task2() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("UPDATE Town  t SET t.name=UPPER(t.name) WHERE length(t.name)<=5 ");

        System.out.println("Affected rows: " + query.executeUpdate());
        transaction.commit();
    }
}
