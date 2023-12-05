package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.exceptions.InvalidAccessLevel;
import com.solvd.teamgamematch.person.AccessLevel;
import com.solvd.teamgamematch.user.CurrentUser;

public class CurrentMenu {
    private static IMenu currentMenu;

    public static IMenu getCurrentMenu() {
        if (currentMenu == null) {
            setMenu();
        }
        return currentMenu;
    }

    public static void setMenu() {
        AccessLevel currentAccessLevel = CurrentUser.getAccessLevel();
        switch (currentAccessLevel) {
            case Guest:
                currentMenu = new GuestMenu();
                break;
            case Standard:
                currentMenu = new StandardMenu();
                break;
            case Administrator:
                currentMenu = new AdministratorMenu();
                break;
            default:
                throw new InvalidAccessLevel("Invalid access level provided when changing menu");
        }
    }
}
