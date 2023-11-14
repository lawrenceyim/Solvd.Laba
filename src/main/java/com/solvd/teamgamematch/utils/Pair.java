package com.solvd.teamgamematch.utils;

/**
 * Pair data structure
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}
