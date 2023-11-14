package com.solvd.teamgamematch.employees;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.employees.roles.Role;
import com.solvd.teamgamematch.person.Person;

import java.math.BigDecimal;

/**
 * Contain information about employees in the company
 *
 * @author Lawrence Yim
 * @version 1.0 31 Oct 2023
 */

public class Employee extends Person {
    BigDecimal salary;
    Role role; // Do not create subclasses with predefined values for the constructors. Those values can be store in files, etc.

    String employeeId;

    public Employee(String name, BigDecimal salary, Role role, String employeeId) {
        super(name);
        this.salary = salary;
        this.role = role;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee Name: " + getName() +
                "\nEmployee ID: " + employeeId +
                "\nSalary: $" + salary +
                role.toString();
    }

    @Override
    public void personDetail() {
        Main.getOutput().displayOutput(getName() + " is an employee");
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
