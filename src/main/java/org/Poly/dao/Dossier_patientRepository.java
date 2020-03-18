package org.Poly.dao;

import org.Poly.entities.Dossier_patient;
import org.Poly.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dossier_patientRepository extends JpaRepository<Dossier_patient, Long> {

	Dossier_patient findByPatient(Patient patient);
}
