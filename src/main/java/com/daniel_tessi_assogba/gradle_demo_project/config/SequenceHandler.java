package com.daniel_tessi_assogba.gradle_demo_project.config;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Following class is used to get unique ID using sequence name
 * @author Daniel Tessi Assogba
 */
@Service
public class SequenceHandler {
    private final EntityManager entityManager;

    public SequenceHandler(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @param sequenceName String
     * @author Daniel Tessi Assogba
     * @return ID as String , It can be parsed into any type of number (Long, Integer)
     */
    @Transactional
    public String generateId(String sequenceName) {

        System.out.println("Tenant schema in generateId: " + sequenceName);

        // Generate the query to get the next value from the sequence
        String query = "select nextval('" + sequenceName + "')";

        // Log the query for debugging purposes (optional)
        System.out.println("Generated Query: " + query);

        // Execute the query and return the result as a String
        return entityManager
                .createNativeQuery(query)
                .getSingleResult()
                .toString();
    }
}
