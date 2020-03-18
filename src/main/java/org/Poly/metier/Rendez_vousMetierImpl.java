package org.Poly.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.Poly.Json.JsonRendez_Vous;
import org.Poly.Json.JsonRendez_Vous1;
import org.Poly.Json.JsonRendez_Vous2;
import org.Poly.dao.CreneauxRepository;
import org.Poly.dao.PatientRepository;
import org.Poly.dao.Rendez_vousRepository;
import org.Poly.entities.Creneaux;
import org.Poly.entities.Patient;
import org.Poly.entities.Rendez_vous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Rendez_vousMetierImpl  implements Rendez_vousMetier {

	@Autowired
	private Rendez_vousRepository rendez_vousrepository;
	@Autowired
	private PatientRepository patientrepository;
	@Autowired
	private CreneauxRepository creneauxrepository;
	
	@Override
	public List<Rendez_vous> listRendez_vous() {
		// TODO Auto-generated method stub
		
		
		
		return rendez_vousrepository.findAll();
	}

	@Override
	@Transactional
	public Rendez_vous createRendez_vous(Long id_creneaux, Long id_patient, String jour, Long id_user)  {
		// TODO Auto-generated method stub
		
		Patient p = patientrepository.findOne(id_patient);
		Creneaux c= creneauxrepository.findOne(id_creneaux);
		
		Rendez_vous r = new Rendez_vous();
		
	    r.setPatient(p);
		r.setCreneaux(c);
		r.setId_secretaire(id_user);
		System.out.println("rendezvous");
		System.out.println(jour);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			d = sdf.parse(jour);
			
			r.setJour(d);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rendez_vousrepository.save(r);
	}

	@Override
	@Transactional
	public List<Rendez_vous> listRendez_vousPatient(Long id_patient) {
		// TODO Auto-generated method stub
		Patient p = patientrepository.findOne(id_patient);
		
		return rendez_vousrepository.findByPatient(p);
	}

	@Override
	public void effacerRendezVous(Long id_rendez_vous) {
		rendez_vousrepository.delete(id_rendez_vous);
		
	}

	@Override
	public List<JsonRendez_Vous2> listRendez_vousAdmin() {
		// TODO Auto-generated method stub
List<JsonRendez_Vous2> list= new  ArrayList<JsonRendez_Vous2>();
		
		
		List<Rendez_vous>	listrendez= rendez_vousrepository.findAll();				
		Iterator<Rendez_vous> iterator = listrendez.iterator();			
		while ( iterator.hasNext() ) {
			Rendez_vous r = iterator.next();
			
			JsonRendez_Vous2 j=new JsonRendez_Vous2();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
	        String date1 = sdf.format(r.getJour());
			
			j.setJour(date1);
			j.setHdebut(r.getCreneaux().getHdebut());
			j.setHfin(r.getCreneaux().getHfin());
		    j.setMdebut(r.getCreneaux().getMdebut());
		    j.setMfin(r.getCreneaux().getMfin());
		    j.setNomMedecin(r.getCreneaux().getUser().getNom());
		    j.setPrenomMedecin(r.getCreneaux().getUser().getPrenom());
		    j.setTypeMedecin(r.getCreneaux().getUser().getType_medecin());
		    j.setIdRdv(r.getId_rendez_vous()); 
		    j.setNomPatient(r.getPatient().getNom_patient());
		    j.setPrenomPatient(r.getPatient().getPrenom_patient());
		
		
	
	        
	        
		list.add(j);
		 
		}
		
       
		
		
		 Collections.sort(list, new Comparator<JsonRendez_Vous2>() {
			    public int compare(JsonRendez_Vous2 m1, JsonRendez_Vous2 m2) {
			        return m1.getJour().compareTo(m2.getJour());
			    }
			}); 
		
		
	   return list;
	}

	
	
	
}
