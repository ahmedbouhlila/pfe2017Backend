package org.Poly.metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.Poly.Json.JsonDossierPatient;
import org.Poly.dao.Dossier_patientRepository;
import org.Poly.dao.PatientRepository;
import org.Poly.entities.Dossier_patient;
import org.Poly.entities.Facture;
import org.Poly.entities.Patient;
import org.Poly.entities.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DossierPatientMetierImpl implements DossierPatientMetier {

	@Autowired
	private PatientRepository patientrepository;
	@Autowired
	private Dossier_patientRepository dossier_patientrepository;



	
		
	
	
	
	@Override
	@Transactional
	public List<JsonDossierPatient> chargerdossier_patient(Long id_patient) {
		// TODO Auto-generated method stub
		List<JsonDossierPatient> list= new  ArrayList<JsonDossierPatient>();
		
		Patient p = patientrepository.findOne(id_patient);
		Dossier_patient dp=dossier_patientrepository.findByPatient(p );
		
	List<Visite> l=(List<Visite>) dp.getVisites();	
		
	Iterator<Visite> iterator = l.iterator();  
	  while ( iterator.hasNext() ) {
		  Visite v = iterator.next();
		
		  JsonDossierPatient json= new JsonDossierPatient();
		  json.setDate_fin(v.getDate_fin());
		  json.setId_visite(v.getId_visite());
		  json.setRapport(v.getRapport());
		 json.setNomMedecin(v.getUser().getNom());
		 json.setPrenomMedecin(v.getUser().getPrenom());
		 json.setTypeMedecin(v.getUser().getType_medecin());
		  json.setAge(v.getDossier_patient().getPatient().getAge());
		  json.setEtat("non facturé");
		  List<Facture> listfac= (List<Facture>) v.getFactures();
		  Iterator<Facture> iteratorfac = listfac.iterator();  
		  while ( iteratorfac.hasNext() ) {
			  Facture f = iteratorfac.next();
			 String x="pharmacien";
		  if( x.equals(f.getTypeFacture()) )
			  json.setEtat("facturé");
		  }
		  
		  list.add(json) ;
	  }
	  Collections.sort(list, new Comparator<JsonDossierPatient>() {
		    public int compare(JsonDossierPatient m1, JsonDossierPatient m2) {
		        return m1.getDate_fin().compareTo(m2.getDate_fin());
		    }
		}); 
	 
	
		return list;
	}

	
	
	
}
