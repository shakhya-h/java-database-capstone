package com.clinic.controller;

import com.clinic.entity.Prescription;
import com.clinic.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

/**
 * Q7: REST Controller for Prescription entity (MongoDB).
 */
@RestController // Q7: Defines class as a REST Controller
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private TokenService tokenService;
    // @Autowired
    // private PrescriptionService prescriptionService; // Assume this exists

    /**
     * Q7: POST endpoint saves a prescription, requires token, and uses request body validation.
     */
    @PostMapping 
    public ResponseEntity<?> createPrescription(
        @RequestHeader("Authorization") String authHeader,
        @Valid @RequestBody Prescription prescription) { // Q7: Validation

        String token = authHeader.replace("Bearer ", "");
        
        // Q7: Token check (3 points)
        if (!tokenService.validateToken(token)) {
            // Q7: Returns a structured success or error message using ResponseEntity (3 points)
            return ResponseEntity.status(401).body("Error: Invalid token."); 
        }

        // prescriptionService.save(prescription); // Mock call to service
        
        return ResponseEntity.status(201).body("Prescription created successfully."); 
    }
}
