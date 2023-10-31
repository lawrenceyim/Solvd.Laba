package com.solvd.teamgamematch.employees;

import java.util.ArrayList;

public class Employees {
    private ArrayList<Employee> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
