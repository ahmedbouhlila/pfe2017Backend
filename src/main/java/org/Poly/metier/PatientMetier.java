package org.Poly.metier;

import java.util.List;

import org.Poly.entities.Patient;



public interface PatientMetier {

	
	
	
	public Patient savePatient(Patient patient);
	public List<Patient> listPatient();
	public List<Patient> loadPatient(Long cin);
	public void modifierPatient(Patient patient);
	public void effacerPatient(Long id_patient);
	public Patient chargerPatient(Long id_patient);
	
}
