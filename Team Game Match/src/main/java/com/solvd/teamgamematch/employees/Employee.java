package com.solvd.teamgamematch.employees;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.employees.roles.Role;
import com.solvd.teamgamematch.person.Person;

import java.math.BigDecimal;

/**
 * Contain information about employees in the company
 *
 * @version 1.0 31 Oct 2023
 * @author Lawrence Yim
 */

public class Employee extends Person {
    BigDecimal salary;
    Role role;

    public Employee(String name, BigDecimal salary, Role role) {
        super(name);
        this.salary = salary;
        this.role = role;
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

    @Override
    public String toString() {
        return "Employee Name: " + getName() +
                "\nSalary: $" + salary +
                role.toString();
    }

    @Override
    public void personDetail() {
        Main.getOutput().displayOutput(getName() + " is an employee");
    }
}
