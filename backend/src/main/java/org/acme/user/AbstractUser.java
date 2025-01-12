package org.acme.user;

import java.util.Objects;

/**
 * Abstract base class implementing common functionality for all user types.
 */
public abstract class AbstractUser implements User {
    private final String id;
    private final String email;
    private final String passwordHash;
    private boolean active;

    protected AbstractUser(String id, String email) {
        this(id, email, null);
    }

    protected AbstractUser(String id, String email, String passwordHash) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.active = true;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractUser)) return false;
        AbstractUser that = (AbstractUser) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
