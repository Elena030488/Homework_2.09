package pro.sky.Homework_2._stream_API.model;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private final String employeeFirstName;
    private final String employeeLastName;
    private int departmentId;
    private int salary;

    public Employee(String employeeFirstName, String employeeLastName) {
        Random random = new Random();
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.departmentId = random.nextInt(2) + 1;
        this.salary = random.nextInt(100) + 10;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeFirstName, employee.employeeFirstName) && Objects.equals(employeeLastName, employee.employeeLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeFirstName, employeeLastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                '}';
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

}
