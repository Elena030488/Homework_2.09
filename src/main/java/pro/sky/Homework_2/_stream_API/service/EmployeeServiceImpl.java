package pro.sky.Homework_2._stream_API.service;

import org.springframework.stereotype.Service;
import pro.sky.Homework_2._stream_API.exceptions.EmployeeAlreadyAddedException;
import pro.sky.Homework_2._stream_API.exceptions.EmployeeNotFoundException;
import pro.sky.Homework_2._stream_API.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements pro.sky.Homework_2._stream_API.service.EmployeeService {
    private final Map<String, Employee> employeeList;
    public EmployeeServiceImpl() {
        this.employeeList = new HashMap<>();
        add("Irina", "Ivanova");
        add("Irina", "Petrova");
        add("Irina", "Frolova");
        add("Irina", "Voronova");
        add("Ivan", "Ivanov");
        add("Ivan", "Petrov");
        add("Ivan", "Frolov");
        add("Ivan", "Voronov");
    }
    @Override
    public Employee add(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employeeList.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        Employee employee = new Employee(firstName, lastName);
        employeeList.put(key, employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employeeList.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудника не существует");
        }
        Employee employee = new Employee(firstName, lastName);
        employeeList.remove(key);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employeeList.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудника не существует");
        }
        return employeeList.get(key);
    }

    @Override
    public Collection<Employee> findAll() {
        return new ArrayList<>(employeeList.values());
    }
    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
