package org.acme.user;

/**
 * Represents an administrator user with full system access.
 */
public class Admin extends AbstractUser {
    private String department;
    private int securityClearanceLevel;

    public Admin(String id, String email, String passwordHash, String department, int securityClearanceLevel) {
        super(id, email, passwordHash);
        this.department = department;
        this.securityClearanceLevel = securityClearanceLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSecurityClearanceLevel() {
        return securityClearanceLevel;
    }

    public void setSecurityClearanceLevel(int securityClearanceLevel) {
        this.securityClearanceLevel = securityClearanceLevel;
    }

    @Override
    public UserRole getRole() {
        return UserRole.ADMIN;
    }
}
