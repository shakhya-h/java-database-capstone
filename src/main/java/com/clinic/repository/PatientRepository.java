package com.clinic.repository;

import com.clinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Q8: Spring Data Repository for Patient entity.
 */
@Repository // Marks interface as a Spring Data JPA repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Q8: Method retrieves patient by email using derived query (2 points)
    Patient findByEmail(String email);

    // Q8: Method retrieves patient by phone number using derived query (2 points)
    Patient findByPhoneNumber(String phoneNumber); 
    
    // You can also define custom queries using @Query here if needed
}
