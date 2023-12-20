package com.marty.first.api.enums;

/**
 * @author Martim Ramos
 */

public enum UserType {

    ADMIN("Administrator"),
    CUSTOMER("Customer");

    private String description;

    /**
     * Constructor
     * @param description String
     */
    UserType(String description) {
        this.description = description;
    }

    /**
     * Constructor
     */
    UserType() {}

    /**
     *
     * @return boolean
     */
    public boolean isAdmin() {
        return ADMIN.equals(this);
    }

    /**
     *
     * @return boolean
     */
    public boolean isCustomer() {
        return CUSTOMER.equals(this);
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
