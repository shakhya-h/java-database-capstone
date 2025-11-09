package com.clinic.security;

import org.springframework.stereotype.Service;

/**
 * Q9: Service to handle JWT generation and validation.
 * NOTE: This is a placeholder; real JWT implementation is complex.
 */
@Service
public class TokenService {

    private final String SIGNING_KEY = "mock-secure-key-1234567890"; // Q9: Configured secret key

    /**
     * Q9: Generates a mock token for a user email.
     */
    public String generateToken(String userEmail) {
        // Mock implementation to represent a token
        return "mock-jwt-" + userEmail + "-" + SIGNING_KEY;
    }

    /**
     * Q9: Implements a method to validate the token.
     */
    public boolean validateToken(String token) {
        // Mock validation: check for expected prefix
        return token != null && token.startsWith("mock-jwt-") && token.contains(SIGNING_KEY);
    }
}
