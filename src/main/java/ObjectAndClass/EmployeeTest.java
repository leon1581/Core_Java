package ObjectAndClass;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        for (Employee employee : staff) {
            employee.raiseSalary(5);
        }

        for (Employee employee : staff) {
            System.out.println("name=" + employee.getName() + ",salary" + employee.getSalary() + ",hireDay=" + employee.getHireDay());
        }

        int nextId = Employee.getNextId();
        System.out.println("Next available id=" + nextId);
    }
}

class Employee {
    private static int nextId = 1;

    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        Objects.requireNonNull(n, "can't be null");
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public static int getNextId() {
        return nextId;
    }

    public void  raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

}
