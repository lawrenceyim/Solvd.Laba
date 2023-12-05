package com.solvd.teamgamematch.employees;

import java.util.ArrayList;

/**
 * Class to manage all the Employee objects
 *
 * @author Lawrence Yim
 * @version 1.0 31 Oct 2023
 */

public class EmployeeManager {
    private static final EmployeeManager instance = new EmployeeManager();
    private final ArrayList<Employee> employees;

    private EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public static EmployeeManager getInstance() {
        return instance;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        }
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }
}
