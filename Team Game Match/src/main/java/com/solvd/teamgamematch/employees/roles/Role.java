package com.solvd.teamgamematch.employees.roles;

/**
 * Abstract class that defines the name and responsibilities of different employee roles
 *
 * @version 1.0 31 Oct 2023
 * @author Lawrence Yim
 */

public abstract class Role {
    private String roleName;
    private String roleResponsibilities;

    public Role(String roleName, String roleResponsibilities) {
        this.roleName = roleName;
        this.roleResponsibilities = roleResponsibilities;
    }

    @Override
    public String toString() {
        return "Role Name: " + roleName +
                "\nResponsibilities: " + roleResponsibilities;
    }

    public abstract void doWork(String employeeName);

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleResponsibilities() {
        return roleResponsibilities;
    }

    public void setRoleResponsibilities(String roleResponsibilities) {
        this.roleResponsibilities = roleResponsibilities;
    }
}
