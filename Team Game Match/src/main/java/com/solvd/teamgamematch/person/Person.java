package com.solvd.teamgamematch.person;

/**
 * Person class that is inherited by the Employee and Player class
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract void personDetail();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
