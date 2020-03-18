package org.Poly.dao;

import java.util.List;

import org.Poly.entities.Patient;
import org.Poly.entities.Rendez_vous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rendez_vousRepository extends JpaRepository<Rendez_vous, Long> {

	List<Rendez_vous> findByPatient(Patient patient);

}
