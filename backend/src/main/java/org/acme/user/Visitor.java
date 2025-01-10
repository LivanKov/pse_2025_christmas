package org.acme.user;

/**
 * Represents a regular visitor user who can browse and order gifts.
 */
public class Visitor extends AbstractUser {
    private String shippingAddress;

    public Visitor(String id, String email, String shippingAddress) {
        super(id, email);
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public UserRole getRole() {
        return UserRole.VISITOR;
    }
}
