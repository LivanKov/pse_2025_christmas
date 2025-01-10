package org.acme.user;

/**
 * Base interface for all users in the system.
 * Defines common properties and methods that all user types must implement.
 */
public interface User {
    /**
     * Get the unique identifier for the user.
     * @return the user's ID
     */
    String getId();

    /**
     * Get the user's email address.
     * @return the email address
     */
    String getEmail();

    /**
     * Get the user's role in the system.
     * @return the user role
     */
    UserRole getRole();

    /**
     * Check if the user's account is currently active.
     * @return true if the account is active, false otherwise
     */
    boolean isActive();

    /**
     * Check if this user type requires password authentication.
     * @return true if password is required, false otherwise
     */
    boolean requiresPassword();
}
