package com.solvd.teamgamematch.person;

/**
 * Person class that is inherited by the Employee and Player class
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public abstract class Person {
    private String name;
    private AccessLevel accessLevel;

    public Person(String name) {
        this.name = name;
        accessLevel = AccessLevel.Guest;
    }

    public Person(String name, AccessLevel accessLevel) {
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public abstract void personDetail();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}
