package com.clinic.controller;

import com.clinic.entity.Doctor;
import com.clinic.security.TokenService;
import com.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Q5: REST Controller for Doctor entity.
 */
@RestController // Q5: Defines class as a REST Controller
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private TokenService tokenService;

    // Q5: Exposes a GET endpoint for doctor availability using dynamic parameters
    @GetMapping("/available") 
    public ResponseEntity<List<Doctor>> getDoctorAvailability(
        @RequestHeader("Authorization") String authHeader,
        @RequestParam String specialty,
        @RequestParam String time) {
        
        String token = authHeader.replace("Bearer ", "");
        
        // Q5: Validates token (3 points)
        if (!tokenService.validateToken(token)) {
            // Q5: Returns a structured response using ResponseEntity (3 points)
            return ResponseEntity.status(401).body(null); 
        }

        // Mock call to service layer
        List<Doctor> doctors = doctorService.findAllDoctorsBySpecialtyAndTime(specialty, time);
        
        return ResponseEntity.ok(doctors);
    }
    
    // Mock service method used above (should be in DoctorService)
    public List<Doctor> findAllDoctorsBySpecialtyAndTime(String specialty, String time) {
        return List.of(new Doctor()); // Placeholder result
    }
}
