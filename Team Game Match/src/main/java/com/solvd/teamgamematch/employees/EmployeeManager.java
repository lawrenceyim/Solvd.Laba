package com.solvd.teamgamematch.employees;

import java.util.ArrayList;

/**
 * Class to manage all the Employee objects
 *
 * @version 1.0 31 Oct 2023
 * @author Lawrence Yim
 */

public class EmployeeManager {
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
