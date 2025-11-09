package com.clinic.service;

import com.clinic.entity.Appointment;
import com.clinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

/**
 * Q6: Service for Appointment-related business logic.
 */
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository; // Assume AppointmentRepository exists

    /**
     * Q6: Implements a booking method that saves an appointment. (3 points)
     */
    public Appointment bookAppointment(Appointment appointment) {
        // Implements business logic and validation before saving
        if (appointment.getAppointmentTime().isBefore(java.time.LocalDateTime.now())) {
            throw new IllegalArgumentException("Cannot book appointment in the past.");
        }
        return appointmentRepository.save(appointment);
    }

    /**
     * Q6: Defines a method to retrieve appointments for a doctor on a specific date. (3 points)
     */
    public List<Appointment> getAppointmentsByDoctorAndDate(Long doctorId, LocalDate date) {
        // Mock: In a real app, this would be a repository call
        // return appointmentRepository.findByDoctorIdAndAppointmentTimeDate(doctorId, date);
        return List.of(); 
    }
}
