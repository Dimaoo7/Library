package pro.sky.librays;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int salary;
    private final int department;

    public Employee(String firstName,String lastName, int salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }


    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return   "Имя: " + firstName +
                " Фамилия: " + lastName +
                " Зарплата: " + salary +
                " Отдел: " + department;
    }

}
