package com.solvd.teamgamematch.person;

import java.util.HashSet;

/**
 * Stores and generate new id numbers for all Person objects
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class IdNumberManager {
    private static IdNumberManager instance;
    // Stored as a String instead of an int because numerical computations will not be performed on this value
    // and integer overflow is not a concern with String data type if the number of Person objects exceed the max value
    private HashSet<String> idNumbers;

    static {
        instance = new IdNumberManager();
    }

    private IdNumberManager() {
        idNumbers = new HashSet<>();
    }

    public static IdNumberManager getInstance() {
        if (instance == null) {
            instance = new IdNumberManager();
        }
        return instance;
    }

    public String generateIdNumber() {
        return String.valueOf(idNumbers.size() + 1);
    }

}
