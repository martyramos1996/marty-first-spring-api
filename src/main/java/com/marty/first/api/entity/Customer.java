package com.marty.first.api.entity;

import com.marty.first.api.enums.Gender;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * @author Martim Ramos
 */

@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = CUSTOMER_ID_SEQUENCE, sequenceName = CUSTOMER_ID_SEQUENCE, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CUSTOMER_ID_SEQUENCE)
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Credentials credentials;

    private static final String CUSTOMER_ID_SEQUENCE = "customer_id_sequence";

    /**
     * Constructor
     * @param id Integer
     * @param name String
     * @param age Integer
     * @param gender Gender
     */
    public Customer(Integer id, String name, Integer age, String email, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    /**
     * Constructor
     */
    public Customer() {}

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
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Integer
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age Integer
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     *
     * @param gender Gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     *
     * @return credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     *
     * @param credentials Credentials
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
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
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id)
                && Objects.equals(name, customer.name)
                && Objects.equals(age, customer.age)
                && Objects.equals(email, customer.email)
                && Objects.equals(gender, customer.gender);

    }

    /**
     * hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email, gender);
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        return "Customer { " + "id = " + id
                + ", name = " + name
                + ", age = " + age
                + ", email = " + email
                + ", gender = " + gender
                + " }";
    }
}
