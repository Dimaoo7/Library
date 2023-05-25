package pro.sky.librays.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.librays.Employee;
import pro.sky.librays.service.DeptService;
import pro.sky.librays.service.EmployeeService;

@RestController
@RequestMapping("/departments")
public class EmployeeController {

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("salary") int salary, @RequestParam("departmentId") int departmentId) {
        return EmployeeService.add(firstName,lastName, salary, departmentId);
    }

    @GetMapping("/delete")
    public Employee deleteEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return EmployeeService.delete(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return EmployeeService.find(firstName, lastName);
    }

    @GetMapping("/max-salary")
    public String getEmployeeMaxSalary(@RequestParam("departmentId") int departmentId) {
        return "<h1>" + DeptService.max(departmentId) + "</h1>";
    }

    @GetMapping("/min-salary")
    public String getEmployeeMinSalary(@RequestParam("departmentId") int departmentId) {
        return "<h1>" + DeptService.min(departmentId) + "</h1>";
    }


    @GetMapping("/all")
    public String getEmployees() {
        return "<h1>" +DeptService.getAllEmployees() + "</h1>";
    }


    @GetMapping(path = "/all", params = "departmentId")
    public String getEmployeesByDept(@RequestParam("departmentId") int departmentId) {
        return "<h1>" + DeptService.getAllEmployeesByDept(departmentId) + "</h1>";
    }
}


