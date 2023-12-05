package com.solvd.teamgamematch.user;

import com.solvd.teamgamematch.person.AccessLevel;

public class CurrentUser {
    private static AccessLevel accessLevel = AccessLevel.Guest;

    public static AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public static void setAccessLevel(AccessLevel level) {
        accessLevel = level;
    }
}
