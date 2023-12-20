package com.marty.first.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Martim Ramos
 */

@SpringBootApplication
public class Main {

    /**
     * Constructor
     */
    public Main() {}

    /**
     * Main method
     * @param args String array
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        return "Main{}";
    }
}
