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
  "patient_id": "P102",
  "heart_rate": 82,
  "spo2": 98,
  "temperature": 98.7
}
```

---

# Clinical Threshold Rules

| Parameter | Safe Range |
|------------|------------|
| Heart Rate | 60 – 100 bpm |
| SpO₂ | ≥95% |
| Temperature | 97°F – 99°F |

---

# Alert Conditions

The system generates a **CRITICAL_ALERT** when:

- Heart Rate < 60 bpm
- Heart Rate > 100 bpm
- SpO₂ < 95%

Otherwise, the patient status is marked as:

```
NORMAL
```

---

# Features

### Clinical Data Processor

- REST API
- DTO Validation
- Exception Handling
- H2 Database Storage
- Clinical Alert Detection
- Layered Spring Boot Architecture
- Patient History Management

---

### PatientVitalsSimulator

- Random Patient Data Generator
- IoT Device Simulation
- Continuous Telemetry Streaming
- REST Client Integration
- Critical Patient Simulation

---

# Workflow

1. Start Spring Boot Application.
2. Start PatientVitalsSimulator.
3. Simulator generates patient vitals.
4. JSON data is sent to Java Backend.
5. Backend validates incoming data.
6. Patient vitals are stored.
7. Threshold rules are evaluated.
8. Alert status is generated.
9. Records become available for clinical review.

---

# Sample Alert Response

```json
{
    "patient_id":"P102",
    "heart_rate":120,
    "spo2":92,
    "temperature":99.5,
    "status":"CRITICAL_ALERT"
}
```

---

# How to Run

## Step 1

Clone Repository

```bash
git clone https://github.com/haritha9014/Medsync-A-Remote-Patient-Vitals-Monitor.git
```

---

## Step 2

Open **Clinical Data Processor** in IntelliJ IDEA.

Run

```
ClinicalDataProcessorApplication.java
```

---

## Step 3

Install Python dependency

```bash
pip install requests
```

---

## Step 4

Run

```
PatientVitalsSimulator/vitals_simulator.py
```

---

## Step 5

Simulator sends patient telemetry to

```
http://localhost:8080/api/vitals
```

---

# Expected Output

- Patient vitals received successfully.
- Data stored in H2 Database.
- Alert generated for abnormal values.
- Normal records stored safely.

---

# Learning Outcomes

This project demonstrates practical knowledge of:

- Java Spring Boot
- REST API Development
- Python Programming
- Service Integration
- JSON Communication
- Database Management
- Healthcare Monitoring Systems
- Git & GitHub Version Control
- Layered Architecture
- Backend Application Development

---

# Future Enhancements

- Docker Support
- MySQL/PostgreSQL Integration
- JWT Authentication
- Email Notifications
- SMS Alerts
- Live Monitoring Dashboard
- Kafka Event Streaming
- Cloud Deployment
- Grafana Monitoring
- Prometheus Metrics

---

# Contributors

### Haritha

**Clinical Data Processor**

- Spring Boot Backend
- REST APIs
- Validation
- Database
- Alert Processing

---

### Teju

**PatientVitalsSimulator**

- Python Simulator
- IoT Data Generation
- REST Client
- Patient Telemetry

---

# License

This project is developed for academic learning and demonstration purposes.

---

## Project Status

**Completed Successfully**

Java Spring Boot ✔

Python Integration ✔

REST APIs ✔

Database ✔

GitHub ✔

Healthcare Monitoring Workflow ✔
