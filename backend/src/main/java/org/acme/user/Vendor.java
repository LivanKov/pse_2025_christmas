package org.acme.user;

/**
 * Represents a vendor user who can manage their gift offerings.
 */
public class Vendor extends AbstractUser {
    private String companyName;
    private String businessId;

    public Vendor(String id, String email, String passwordHash, String companyName, String businessId) {
        super(id, email, passwordHash);
        this.companyName = companyName;
        this.businessId = businessId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    @Override
    public UserRole getRole() {
        return UserRole.VENDOR;
    }
}
