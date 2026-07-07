"""
MedSync Configuration File
Stores application level configuration.
"""

# Java Spring Boot API URL
SERVER_URL = "http://localhost:8080/api/vitals"

# Send data every 5 seconds
TRANSMISSION_INTERVAL = 5

# SQLite database file
DATABASE_NAME = "medsync.db"

# Sample Patients
PATIENT_IDS = [
    "P101",
    "P102",
    "P103",
    "P104",
    "P105"
]