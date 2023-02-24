package еncapsulation.salaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double bonus) {
        if (getAge() < 30) {
            setSalary(getSalary()+(getSalary()*bonus/200));
        }else {
            setSalary(getSalary()+(getSalary()*bonus/100));
        }

    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva", getFirstName(), getLastName(), getSalary());
    }
}
