package com.solvd.teamgamematch.employees;

import java.util.ArrayList;

/**
 * Class to manage all the Employee objects
 *
 * @author Lawrence Yim
 * @version 1.0 31 Oct 2023
 */

public class EmployeeManager {
    private final ArrayList<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
