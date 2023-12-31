package com.marty.first.api.entity;

import com.marty.first.api.enums.UserType;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * @author Martim Ramos
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Credentials.usernameTaken",
                query = "SELECT CASE WHEN COUNT(cs) > 0 THEN TRUE ELSE FALSE END FROM Credentials cs WHERE cs.username = :username")
})
public class Credentials {

    @Id
    @SequenceGenerator(name = CREDENTIALS_ID_SEQUENCE, sequenceName = CREDENTIALS_ID_SEQUENCE, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CREDENTIALS_ID_SEQUENCE)
    private Integer id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private static final String CREDENTIALS_ID_SEQUENCE = "credentials_id_sequence";

    /**
     * Constructor
     * @param id Integer
     * @param username String
     * @param password String
     * @param userType UserType
     */
    public Credentials(Integer id, String username, String password, UserType userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    /**
     * Constructor
     */
    public Credentials() {}

    /**
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id Integer
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     *
     * @param userType UserType
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * equals method
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials credentials = (Credentials) o;
        return Objects.equals(id, credentials.id)
                && Objects.equals(username, credentials.username)
                && Objects.equals(password, credentials.password)
                && Objects.equals(userType, credentials.userType);
    }

    /**
     * hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, userType);
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        return "Credentials { " + "id = " + id
                + ", username = " + username
                + ", password = " + password
                + ", userType = " + userType
                + " }";
    }

}
