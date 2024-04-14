package pro.sky.Homework_2._stream_API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Homework_2._stream_API.model.Employee;
import  pro.sky.Homework_2._stream_API.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }
    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> getEmployees(@RequestParam Integer departmentId) {
        return departmentService.getEmployee(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getEmployee();
    }
}
