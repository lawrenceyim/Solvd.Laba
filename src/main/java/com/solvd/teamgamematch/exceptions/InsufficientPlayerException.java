package com.solvd.teamgamematch.exceptions;

public class InsufficientPlayerException extends RuntimeException {
    public InsufficientPlayerException(String message) {
        super(message);
    }
}
