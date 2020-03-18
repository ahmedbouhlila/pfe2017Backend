package org.Poly.metier;

import java.util.List;
import java.util.Random;

import org.Poly.dao.CreneauxRepository;
import org.Poly.dao.Dossier_patientRepository;
import org.Poly.dao.PatientRepository;
import org.Poly.dao.UserRepository;
import org.Poly.entities.Creneaux;
import org.Poly.entities.Dossier_patient;
import org.Poly.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientMetierImpl  implements PatientMetier {

	@Autowired
	private PatientRepository patientrepository;
	@Autowired
	private Dossier_patientRepository dossier_patientrepository;
	

	
	@Override
	@Transactional
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		Dossier_patient  dossier =new Dossier_patient();
		// create random object
		   Random randomno = new Random();
		     
		   // get next long value 
		    long num =   (long) Math.abs(randomno.nextInt());
		 
		dossier.setNum_dossier(num);
		patient.setDossier_patient(dossier);
		
		dossier.setPatient(patient);
		dossier_patientrepository.save(dossier);
		
		return patientrepository.save(patient) ;
	
	
	}

	@Override
	public List<Patient> listPatient() {
		// TODO Auto-generated method stub
		return patientrepository.findAll();
	}

	@Override
	public List<Patient>loadPatient(Long cin) {
		// TODO Auto-generated method stub
		return patientrepository.findByCin(cin) ;
	}

	@Override
	@Transactional
	public void modifierPatient(Patient patient) {
		
	 patientrepository.updatePatient(patient.getNom_patient(),patient.getPrenom_patient(),patient.getSex(),patient.getAge(),patient.getEmail_patient(),patient.getSituation_fam(),patient.getProfession_patient(),patient.getDate_naiss(),patient.getCin(),patient.getGRP_SANGIN(),patient.getId_patient());	
		
	
	}

	@Override
	@Transactional
	public void effacerPatient(Long id_patient) {
		// TODO Auto-generated method stub
		patientrepository.delete(id_patient);
	}

	@Override
	public Patient chargerPatient(Long id_patient) {
		// TODO Auto-generated method stub
		
		
		return patientrepository.findOne(id_patient);
	}

	
	
	
}
