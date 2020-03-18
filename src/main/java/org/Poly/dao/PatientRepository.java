package org.Poly.dao;

import java.util.Date;
import java.util.List;

import org.Poly.entities.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	List<Patient> findByCin(Long cin);

	@Modifying
	@Query("Update Patient p SET p.nom_patient=:nom_patient, p.prenom_patient=:prenom_patient, p.nom_patient=:nom_patient, p.sex=:sex, p.age=:age, p.email_patient=:email_patient, p.situation_fam=:situation_fam, p.profession_patient=:profession_patient, p.date_naiss=:date_naiss, p.cin=:cin, p.GRP_SANGIN=:GRP_SANGIN   WHERE p.id_patient=:id_patient")
	public void updatePatient(@Param("nom_patient") String nom_patient, @Param("prenom_patient") String prenom_patient,
			@Param("sex") String sex, @Param("age") int age, @Param("email_patient") String email_patient,
			@Param("situation_fam") String situation_fam, @Param("profession_patient") String profession_patient,
			@Param("date_naiss") Date date_naiss, @Param("cin") Long cin, @Param("GRP_SANGIN") String GRP_SANGIN,
			@Param("id_patient") Long id_patient);

}
