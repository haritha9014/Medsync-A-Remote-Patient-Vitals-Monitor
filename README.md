# MedSync – Remote Patient Vitals Monitor

## Overview

MedSync – Remote Patient Vitals Monitor is a healthcare monitoring application developed to simulate real-time patient vital sign monitoring using a distributed architecture. The project demonstrates seamless integration between a Python-based IoT patient simulator and a Java Spring Boot clinical processing system.

The application continuously monitors patient health parameters, stores medical records, analyzes vital signs against predefined clinical thresholds, and generates alerts for abnormal conditions.

This project showcases REST API development, backend processing, database integration, service-to-service communication, and collaborative software development using Java and Python.

---

# Project Objectives

- Simulate real-time patient vital data.
- Receive and process medical telemetry securely.
- Store patient health records.
- Detect abnormal vital signs automatically.
- Generate clinical alerts for critical patients.
- Demonstrate Java–Python integration.

---

# Real-World Use Case

Hospitals use wearable medical devices to continuously monitor patients after discharge.

These wearable devices periodically transmit:

- Heart Rate
- Blood Oxygen (SpO₂)
- Body Temperature

If any value crosses the safe clinical range, the monitoring system immediately flags the patient for clinical review.

MedSync simulates this workflow by integrating a Python simulator with a Java backend.

---

# Team Modules

## Haritha – Clinical Data Processor (Java)

Responsible for developing the backend processing engine using Spring Boot.

### Responsibilities

- REST API Development
- Patient Vitals Processing
- JSON Request Validation
- Business Logic Implementation
- Clinical Threshold Evaluation
- H2 Database Integration
- Patient History Storage
- Alert Generation

---

## Teju – PatientVitalsSimulator (Python)

Responsible for developing the patient wearable simulator.

### Responsibilities

- Generate Mock Patient Data
- Simulate IoT Wearable Device
- Generate Random Vitals
- Convert Data to JSON
- Send Data to Java REST API
- Simulate Critical Patient Conditions

---

# System Architecture

```
+---------------------------+
| PatientVitalsSimulator    |
| (Python)                  |
+-------------+-------------+
              |
              | HTTP POST (JSON)
              |
              v
+---------------------------+
| Clinical Data Processor   |
| Spring Boot REST API      |
+-------------+-------------+
              |
              |
      Validate Patient Data
              |
      Clinical Threshold Check
              |
              |
      Store in H2 Database
              |
              |
      Generate Alerts
```

---

# Repository Structure

```
Medsync-A-Remote-Patient-Vitals-Monitor

│
├── Clinical Data Processor
│      ├── src
│      ├── resources
│      ├── pom.xml
│      └── README
│
├── PatientVitalsSimulator
│      ├── src
│      ├── requirements.txt
│      └── README
│
├── MedSync Functional Architecture Document.docx
│
├── MedSync Technical Architecture Document.docx
│
├── README.md
│
└── .gitignore
```

---

# Technology Stack

## Backend

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

---

## Python Module

- Python 3
- Requests
- JSON
- Random
- Time

---

## Development Tools

- IntelliJ IDEA
- VS Code
- Git
- GitHub
- Postman
- H2 Console

---

# JSON Data Contract

Example Request

```json
{
"patientId" : "P001",
"heartRate" : 72,
"bloodPressure" : "120/80",
"temperature" : 36.5,
"timestamp" : "2026-04-05T10:30:00Z"
"status" : "NORMAL"
}
