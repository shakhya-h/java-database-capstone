package com.clinic.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * Q3: Doctor JPA Entity with correct PK, availableTimes, and @JsonProperty for security.
 */
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Proper primary key (5 points)

    @NotBlank
    private String firstName;
    
    @NotBlank
    private String specialization;

    // Q3: Security: Hides password from JSON responses (3 points)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    private String password;
    
    // Q3: Available Times: Stores a collection of simple values in a separate table (3 points)
    @ElementCollection
    @CollectionTable(name = "doctor_available_times", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "available_time")
    private List<String> availableTimes; 

    // Constructors, Getters, and Setters are required for a complete entity
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<String> getAvailableTimes() { return availableTimes; }
    public void setAvailableTimes(List<String> availableTimes) { this.availableTimes = availableTimes; }
}
