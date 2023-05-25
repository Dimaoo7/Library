package pro.sky.librays.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.librays.Employee;
import pro.sky.librays.exceptions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class EmployeeService {

    protected static Map<String, Employee> employeeList = new HashMap<>(Map.of(
            "John Doe",
            new Employee("John", "Doe", 1500, 1),
            "Jane Doe",
            new Employee("Jane", "Doe", 5000, 2),
            "Jack Doe",
            new Employee("Jack ", "Piers", 3000, 1),
            "Kakbez Smith",
            new Employee("Kakbez", " Smith", 4000, 2),
            "Nyi Biden",
            new Employee("Nyi ", "Biden", 3500, 3),
            "Johan Libert",
            new Employee("Johan ", "Libert", 15000, 3)
    ));

    private static final int MAX_SIZE = 15;

    public static Employee add(String firstName, String lastName, int salary, int department) {
        if (employeeList.size() == MAX_SIZE) {

            throw new EmployeeStorageIsFullException();

        } else if (employeeList.containsKey(firstName.toLowerCase())) {

            throw new EmployeeAlreadyAddedException();

        } else if (department < 1 || department > 3) {

            throw new NotFoundException();

        } else if (salary < 0) {

            throw new NotFoundException();

        } else if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {

            throw new BadRequestException();

        } else if (!Pattern.matches("[a-zA-Z]+", firstName + lastName)) {

            throw new NotFoundException();

        } else if (StringUtils.containsWhitespace(firstName) || StringUtils.containsWhitespace(lastName)) {

            throw new BadRequestException();
        }

        return employeeList.put(StringUtils.capitalize(firstName) + " " + StringUtils.capitalize(lastName), new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, department));
    }

    public static Employee delete(String firstName, String lastName) {
        String key = StringUtils.capitalize(firstName) + " " + StringUtils.capitalize(lastName);
        if (!employeeList.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employeeList.remove(key);
    }

    public static Employee find(String firstName, String lastName) {
        String key = StringUtils.capitalize(firstName) + " " + StringUtils.capitalize(lastName);
        if (!employeeList.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employeeList.get(key);
    }

}


