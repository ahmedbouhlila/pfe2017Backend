package org.Poly.metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.Poly.Json.JsonPrescription;
import org.Poly.Json.JsonRendez_Vous;
import org.Poly.dao.MedicamentsRepository;
import org.Poly.dao.Ordonnance_globaleRepository;
import org.Poly.dao.Ordonnance_typeRepository;
import org.Poly.dao.Prescription1Repository;
import org.Poly.dao.PrescriptionRepository;
import org.Poly.dao.UserRepository;
import org.Poly.entities.Medicaments;
import org.Poly.entities.Ordonnance_globale;
import org.Poly.entities.Ordonnance_type;
import org.Poly.entities.Prescription;
import org.Poly.entities.Prescription1;
import org.Poly.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class OrdonnanceMetierImpl implements OrdonnanceMetier  {
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private Ordonnance_typeRepository ordonnance_typerepository;	
	@Autowired
	private MedicamentsRepository medicamentsrepository;
	
	@Autowired
	private Prescription1Repository Prescription1repository;
	@Autowired
	private PrescriptionRepository Prescriptionrepository;

	@Autowired
	private Ordonnance_globaleRepository ordonnance_globalerepository;	
	
	@Override
	@Transactional
	public List<Ordonnance_type> listordonnancetype(Long id_medecin) {
		// TODO Auto-generated method stub
		User u = userrepository.findOne(id_medecin);
		
		
		return ordonnance_typerepository.findByUser(u);
	}


	@Override
	@Transactional
	public Ordonnance_type saveordonnancetype(Ordonnance_type o) {
		
		
		return ordonnance_typerepository.save(o);

	}


	@Override
	@Transactional
	public Boolean saveordonnancetype(List<JsonPrescription> l) {
		String nom;
		Long idUser;
		Long idOrdonnance;
		Iterator<JsonPrescription> iterator1 = l.iterator();
		 if (!iterator1.hasNext()){
			 return false;
		 }
		 
		 
		 JsonPrescription j= iterator1.next();
		  idUser=j.getId();
		 nom=j.getOrdonnance();
		  Ordonnance_type o =new Ordonnance_type();
		  
		  User u = userrepository.findOne(idUser);
		  
		  
		  o.setUser(u);
		  o.setNom(nom);
		 // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		 o.setDate_ord( new Date());
		  idOrdonnance=ordonnance_typerepository.save(o).getId_ordonnance_type() ;
		 
		  Ordonnance_type ot=ordonnance_typerepository.findOne(idOrdonnance);
		  
		  Iterator<JsonPrescription> iterator = l.iterator();  
		  while ( iterator.hasNext() ) {
			  JsonPrescription p = iterator.next();
		   
			Medicaments m=   medicamentsrepository.findByNom(p.getNom());
		
			Prescription1   p1= new Prescription1();
			p1.setForm_med(p.getFormMed());
			p1.setMedicaments(m);
			p1.setNbr_fois_med(p.getNbrFoisMed());
			p1.setOrdonnance_type(ot);
			p1.setQuant_med(p.getQuantMed());
			Prescription1repository.save(p1);
			
		  }
	
		
		
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@Transactional
	public List<JsonPrescription> chargerordonnancetype(Long idOrdonnance) {
		// TODO Auto-generated method stub
		List<JsonPrescription> list= new  ArrayList<JsonPrescription>();
		Ordonnance_type ot=ordonnance_typerepository.findOne(idOrdonnance);
   		
	List<Prescription1> l=(List<Prescription1>) ot.getPrescription1();	
		
	Iterator<Prescription1> iterator = l.iterator();  
	  while ( iterator.hasNext() ) {
		  Prescription1 p = iterator.next();
		  JsonPrescription json= new JsonPrescription();
		  json.setFormMed(p.getForm_med());
		  json.setNbrFoisMed(p.getNbr_fois_med());
		  json.setQuantMed(p.getQuant_med());
		  json.setNom(p.getMedicaments().getNom());
		  
		  
		  list.add(json) ;
	  }
		  
	
		return list;
	}


	@Override
	public List<Ordonnance_globale> listordonnanceglobale() {
		// TODO Auto-generated method stub
		return ordonnance_globalerepository.findAll();
	}


	@Override
	@Transactional
	public List<JsonPrescription> chargerordonnanceglobale(Long idOrdonnanceglobale) {
		// TODO Auto-generated method stub
		
		List<JsonPrescription> list= new  ArrayList<JsonPrescription>();
		Ordonnance_globale ot=ordonnance_globalerepository.findOne(idOrdonnanceglobale);
		
		
		List<Prescription> l=(List<Prescription>) ot.getPrescription();	
			
		Iterator<Prescription> iterator = l.iterator();  
		  while ( iterator.hasNext() ) {
			  Prescription p = iterator.next();
			  JsonPrescription json= new JsonPrescription();
			  json.setFormMed(p.getForm_med());
			  json.setNbrFoisMed(p.getNbr_fois_med());
			  json.setQuantMed(p.getQuant_med());
			  json.setNom(p.getMedicaments().getNom());
			  
			  
			  list.add(json) ;
		  }
			  
		
			return list;
		}


	@Override
	@Transactional
	public Boolean saveordonnanceGlobale(List<JsonPrescription> l) {
		// TODO Auto-generated method stub
		
		
		String nom;
		Long idOrdonnance;
		Iterator<JsonPrescription> iterator1 = l.iterator();
		 if (!iterator1.hasNext()){
			 return false;
		 }
		 
		 
		 JsonPrescription j= iterator1.next();
		  
		 nom=j.getOrdonnance();
		  Ordonnance_globale o =new Ordonnance_globale();
		  
		  
		
		  
		 
		  o.setNom(nom);
		 // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		 o.setDate_ord( new Date());
		
		idOrdonnance= ordonnance_globalerepository.save(o).getId_ordonnance_globale();
		 
		  
		 Ordonnance_globale og=ordonnance_globalerepository.findOne(idOrdonnance);
		  
		  
		  Iterator<JsonPrescription> iterator = l.iterator();  
		  while ( iterator.hasNext() ) {
			  JsonPrescription p = iterator.next();
		   
			Medicaments m=   medicamentsrepository.findByNom(p.getNom());
		
			Prescription   p1= new Prescription();
			p1.setForm_med(p.getFormMed());
			p1.setMedicaments(m);
			p1.setNbr_fois_med(p.getNbrFoisMed());
			p1.setOrdonnance_globale(og);
			
			p1.setQuant_med(p.getQuantMed());
			
			Prescriptionrepository.save(p1);
			
		  }
	
		
		
		// TODO Auto-generated method stub
		return true;
		
		
		
		
		
	}


	@Override
	public Boolean effacerordonnancetype(Long idOrdonnance) {
		// TODO Auto-generated method stub
		ordonnance_typerepository.delete(idOrdonnance);
		return true;
	}


	@Override
	@Transactional
	public Boolean modifierordonnancetype(List<JsonPrescription> l, Long idordonnance, String nom) {
		// TODO Auto-generated method stub
		
		
		Iterator<JsonPrescription> iterator1 = l.iterator();
		 if (!iterator1.hasNext()){
			 return false;
		 }
		 
		 Ordonnance_type o = ordonnance_typerepository.findOne(idordonnance);
		 o.setNom(nom);
		
		 List<Prescription1> listeprescription = (List<Prescription1>) o.getPrescription1();
		 Iterator<Prescription1> iterator2 = listeprescription.iterator(); 
		 System.out.println("eeeee");
		 while ( iterator2.hasNext() ) {
			 
			 System.out.println("aaaa");
			  Prescription1 p = iterator2.next();
			  Prescription1repository.delete(p);
		 
		 }
		 
		
		 
		   
		  Iterator<JsonPrescription> iterator = l.iterator();  
		  while ( iterator.hasNext() ) {
			  JsonPrescription p = iterator.next();
		   
			Medicaments m=   medicamentsrepository.findByNom(p.getNom());
		
			Prescription1   p1= new Prescription1();
			p1.setForm_med(p.getFormMed());
			p1.setMedicaments(m);
			p1.setNbr_fois_med(p.getNbrFoisMed());
			p1.setOrdonnance_type(o);
			p1.setQuant_med(p.getQuantMed());
			Prescription1repository.save(p1);
			
		  }
	
		  ordonnance_typerepository.save(o);
		
		// TODO Auto-generated method stub
		return true;
		
		
		
		
	}

	
	
	
}
