package com.medsync.controller;

import com.medsync.entity.PatientVitals;
import com.medsync.service.VitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * VitalsController
 *
 * This REST Controller handles all incoming API requests
 * related to patient vital signs data.
 *
 * Responsibilities:
 * 1. Receive patient vitals from IoT devices/simulators.
 * 2. Store vitals in the database.
 * 3. Retrieve all recorded vitals.
 * 4. Retrieve critical patient alerts.
 *
 * Base URL:
 * http://localhost:8080/api
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VitalsController {

    /**
     * Injects the VitalsService dependency.
     * Service layer contains business logic.
     */
    @Autowired
    private VitalsService service;

    /**
     * Receives patient vitals data from an external source
     * such as an IoT device, simulator, or Postman request.
     *
     * Endpoint:
     * POST /api/vitals
     *
     * Sample Request Body:
     * {
     *   "patientId": "P001",
     *   "heartRate": 110,
     *   "oxygenLevel": 92,
     *   "temperature": 38.5
     * }
     *
     * @param vitals Patient vital information received in JSON format
     * @return Saved PatientVitals object
     */
    @PostMapping("/vitals")
    public PatientVitals receiveVitals(
            @RequestBody PatientVitals vitals) {

        return service.saveVitals(vitals);
    }

    /**
     * Retrieves all patient vitals stored in the database.
     *
     * Endpoint:
     * GET /api/vitals
     *
     * @return List of all patient vital records
     */
    @GetMapping("/vitals")
    public List<PatientVitals> getAllVitals() {
        return service.getAllVitals();
    }

    /**
     * Retrieves only critical patient records
     * that require immediate medical attention.
     *
     * Endpoint:
     * GET /api/alerts
     *
     * @return List of critical patient alerts
     */
    @GetMapping("/alerts")
    public List<PatientVitals> getAlerts() {
        return service.getAlerts();
    }
}
