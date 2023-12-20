package com.marty.first.api.enums;

/**
 * @author Martim Ramos
 */

public enum Gender {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String description;

    /**
     * Constructor
     * @param description String
     */
    Gender(String description) {
        this.description = description;
    }

    /**
     * Constructor
     */
    Gender() {}

    /**
     *
     * @return boolean
     */
    public boolean isMale() {
        return MALE.equals(this);
    }

    /**
     *
     * @return boolean
     */
    public boolean isFemale() {
        return FEMALE.equals(this);
    }

    /**
     *
     * @return boolean
     */
    public boolean isOther() {
        return OTHER.equals(this);
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
