Database Schema Design for Smart Clinic Management System

1. MySQL Relational Schema (Core Transactional Data)

This schema is used for highly structured data where ACID properties (Atomicity, Consistency, Isolation, Durability) and relationships are critical (e.g., Accounts and Appointments).

Table Name

Column Name

Data Type

Key/Constraint

Description

admin

id

BIGINT

PRIMARY KEY, AUTO_INCREMENT

Unique ID for Admin users.



username

VARCHAR(50)

UNIQUE, NOT NULL

Login username.



password

VARCHAR(255)

NOT NULL

Hashed password.

patient

id

BIGINT

PRIMARY KEY, AUTO_INCREMENT

Patient's unique identifier.



first_name

VARCHAR(100)

NOT NULL

Patient's first name.



email

VARCHAR(100)

UNIQUE, NOT NULL

Patient's contact email.



phone_number

VARCHAR(15)

UNIQUE

Patient's phone number.

doctor

id

BIGINT

PRIMARY KEY, AUTO_INCREMENT

Doctor's unique identifier.



first_name

VARCHAR(100)

NOT NULL

Doctor's first name.



specialization

VARCHAR(100)

NOT NULL

Medical specialty (e.g., Cardiology).



password

VARCHAR(255)

NOT NULL

Hashed password.

appointment

id

BIGINT

PRIMARY KEY, AUTO_INCREMENT

Unique appointment ID.



patient_id

BIGINT

FOREIGN KEY (patient.id)

Link to the patient.



doctor_id

BIGINT

FOREIGN KEY (doctor.id)

Link to the assigned doctor.



appointment_time

DATETIME

NOT NULL

The scheduled date and time.



status

VARCHAR(20)

NOT NULL

Status (e.g., SCHEDULED, CANCELED).

2. MongoDB Document Schema (Flexible Data)

This schema uses a document database (MongoDB) to store flexible, less structured data like prescriptions and logs, which may have variable fields.

Collection Name: prescriptions

Design Justification: Prescriptions often contain complex, nested data (multiple medications, specific instructions) that change over time, making them ideal for the flexible JSON-like structure of MongoDB.

Realistic JSON Document Example (with Nesting):

{
  "_id": { "$oid": "6511a547d6a5c37890b12345" },
  "patientId": 101,          // Link to MySQL patient.id
  "doctorId": 201,            // Link to MySQL doctor.id
  "issueDate": { "$date": "2025-11-09T10:00:00.000Z" },
  "diagnosis": "Acute Bronchitis",
  "medications": [ // Array of nested medication objects
    {
      "name": "Amoxicillin",
      "dosage": "500mg",
      "frequency": "Three times daily",
      "durationDays": 10,
      "refillsAllowed": 0
    },
    {
      "name": "Cough Syrup",
      "dosage": "10ml",
      "frequency": "As needed",
      "durationDays": 5
    }
  ],
  "doctorNotes": "Patient advised rest and increased fluid intake."
}

