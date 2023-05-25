package pro.sky.librays.service;



import org.springframework.stereotype.Service;
import pro.sky.librays.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptService {

    static EmployeeService employeeService;

    public DeptService(EmployeeService employeeService) {
        DeptService.employeeService = employeeService;
    }

    public static Employee max(int dept){
        return EmployeeService.employeeList.values().stream()
                .filter(employee -> employee.getDepartment() == dept)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public static Employee min(int dept){
        return EmployeeService.employeeList.values().stream()
                .filter(employee -> employee.getDepartment() == dept)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public static List<Employee> getAllEmployees(){
        return EmployeeService.employeeList.values().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public static List<Employee> getAllEmployeesByDept(int dept){
        return EmployeeService.employeeList.values().stream()
                .filter(employee -> employee.getDepartment() == dept)
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }
}