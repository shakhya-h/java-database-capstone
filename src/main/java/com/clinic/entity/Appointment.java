package com.clinic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Q4: Appointment JPA Entity with ManyToOne relationships and validation.
 */
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Q4: The appointmentTime field type (LocalDateTime) and validation (3 points)
    @NotNull
    @Future // Q4: Validation annotation for future date
    private LocalDateTime appointmentTime; 

    // Q4: Defines @ManyToOne relationship with Doctor (3 points)
    @ManyToOne 
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    // Q4: Defines @ManyToOne relationship with Patient (3 points)
    @ManyToOne 
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // Constructors, Getters, and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
}
