package com.solvd.teamgamematch.employees;

import com.solvd.teamgamematch.output.CurrentOutput;
import com.solvd.teamgamematch.person.AccessLevel;
import com.solvd.teamgamematch.person.Person;

import java.math.BigDecimal;

/**
 * Contain information about employees in the company
 *
 * @author Lawrence Yim
 * @version 1.0 31 Oct 2023
 */

public class Employee extends Person {
    private BigDecimal salary;
    private String employeeId;

    public Employee(String name, BigDecimal salary, String employeeId) {
        super(name, AccessLevel.Standard);
        this.salary = salary;
        this.employeeId = employeeId;
    }

    public Employee(String name, BigDecimal salary, String employeeId, AccessLevel accessLevel) {
        super(name, accessLevel);
        this.salary = salary;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee Name: " + getName() + System.lineSeparator() +
                "Employee ID: " + employeeId + System.lineSeparator() +
                "Salary: $" + salary + System.lineSeparator() +
                "Access Level: " + getAccessLevel() + System.lineSeparator();
    }

    @Override
    public void personDetail() {
        CurrentOutput.getCurrentOutput().displayOutput(getName() + " is an employee");
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
