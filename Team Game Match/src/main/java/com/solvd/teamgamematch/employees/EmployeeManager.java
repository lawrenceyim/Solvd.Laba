package com.solvd.teamgamematch.employees;

import java.util.ArrayList;

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
