package com.medsync.repository;

import com.medsync.entity.PatientVitals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * PatientVitalsRepository
 *
 * Repository layer responsible for database operations
 * related to the PatientVitals entity.
 *
 * JpaRepository provides built-in methods such as:
 * - save()
 * - findAll()
 * - findById()
 * - deleteById()
 * - count()
 *
 * No implementation is required because Spring Data JPA
 * automatically generates the implementation at runtime.
 */
public interface PatientVitalsRepository extends JpaRepository<PatientVitals, Long> {
    /**
     * Retrieves all patient records that match
     * the given health status.
     *
     * Spring Data JPA automatically creates the query:
     *
     * SELECT * FROM patient_vitals
     * WHERE status = ?
     *
     * Example:
     * findByStatus("CRITICAL")
     *
     * @param status Patient health status
     *               (NORMAL, WARNING, CRITICAL)
     * @return List of matching patient vital records
     */
    List<PatientVitals> findByStatus(String status);

}