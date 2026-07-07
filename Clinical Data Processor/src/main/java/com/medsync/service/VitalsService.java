package com.medsync.service;

import com.medsync.entity.PatientVitals;
import com.medsync.repository.PatientVitalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * VitalsService
 *
 * Service layer that contains all business logic for patient vitals processing.
 * This class is responsible for validating vitals, checking thresholds,
 * saving to database, and retrieving data.
 *
 * Controllers should not contain business logic - they delegate to this service.
 */
@Service
// Marks this class as a Spring Service bean. Spring will create and manage this object.
public class VitalsService {

    // @Autowired injects the PatientVitalsRepository bean.
    // Repository handles all database operations for PatientVitals entity.
    @Autowired
    private PatientVitalsRepository repository;

    /**
     * saveVitals
     *
     * Processes incoming vitals data: validates against thresholds,
     * sets alert status, and saves to database.
     *
     * Business Rule:
     * Heart Rate < 60 or > 100 = CRITICAL
     * SpO2 < 95 = CRITICAL
     * Otherwise = NORMAL
     *
     * @param vitals - PatientVitals object from controller with patientId, heartRate, spo2
     * @return PatientVitals - Saved entity with generated ID, timestamp, and status
     */
    public PatientVitals saveVitals(PatientVitals vitals) {

        // Check if vitals are outside normal range - Critical condition check
        if (vitals.getHeartRate() < 60 ||
                vitals.getHeartRate() > 100 ||
                vitals.getSpo2() < 95) {

            // If any value is critical, set status to CRITICAL_ALERT
            // This flag helps dashboard identify urgent cases
            vitals.setStatus("CRITICAL_ALERT");

        } else {

            // All vitals are within normal range
            vitals.setStatus("NORMAL");
        }

        // Save the vitals record to database using JPA repository
        // repository.save() handles both INSERT for new records and UPDATE for existing
        return repository.save(vitals);
    }

    /**
     * getAllVitals
     *
     * Fetches all vitals records from database for dashboard display.
     * Used to show patient history, trends, and complete audit trail.
     *
     * @return List<PatientVitals> - All records from PATIENT_VITALS table
     */
    public List<PatientVitals> getAllVitals() {

        // findAll() is a built-in JPA method that returns all rows from the table
        return repository.findAll();
    }

    /**
     * getAlerts
     *
     * Fetches only critical vitals records where status = "CRITICAL_ALERT".
     * Used by alerts dashboard to show patients needing immediate attention.
     *
     * @return List<PatientVitals> - Filtered list of critical records only
     */
    public List<PatientVitals> getAlerts() {

        // Custom query method defined in PatientVitalsRepository
        // Returns only records where status column = "CRITICAL_ALERT"
        return repository.findByStatus("CRITICAL_ALERT");
    }
}