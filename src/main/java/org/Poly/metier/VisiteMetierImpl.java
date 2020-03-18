package org.Poly.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.Poly.Json.JsonOrdonnance;
import org.Poly.Json.JsonOrdonnancePharmacien;
import org.Poly.Json.JsonPrescription;
import org.Poly.Json.JsonRendez_Vous2;
import org.Poly.Json.JsonVisite;
import org.Poly.dao.Dossier_patientRepository;
import org.Poly.dao.FactureRepository;
import org.Poly.dao.MedicamentsRepository;
import org.Poly.dao.OrdonnanceRepository;
import org.Poly.dao.PatientRepository;
import org.Poly.dao.Prescription1Repository;
import org.Poly.dao.Prescription2Repository;
import org.Poly.dao.Rendez_vousRepository;
import org.Poly.dao.UserRepository;
import org.Poly.dao.VisiteRepository;
import org.Poly.entities.Dossier_patient;
import org.Poly.entities.Facture;
import org.Poly.entities.Medicaments;
import org.Poly.entities.Ordonnance;
import org.Poly.entities.Patient;
import org.Poly.entities.Prescription1;
import org.Poly.entities.Prescription2;
import org.Poly.entities.User;
import org.Poly.entities.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class VisiteMetierImpl  implements VisiteMetier {

	@Autowired
	private VisiteRepository visiterepository;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	public Prescription2Repository prescription2repository;
	@Autowired
	private MedicamentsRepository medicamentsrepository;
	@Autowired
	private OrdonnanceRepository ordonnancerepository;
	@Autowired
	private PatientRepository patientrepository;
	@Autowired
	private Dossier_patientRepository dossier_patientrepository;
	@Autowired
	private FactureRepository facturerepository;
	@Autowired
	private Rendez_vousRepository rendez_vousrepository;
	
	@Override
	public List<Visite> listVisite() {
		// TODO Auto-generated method stub
		return visiterepository.findAll();
	}
	@Override
	@Transactional
	public Boolean ajoutvisite(List<JsonVisite> l) {
		// TODO Auto-generated method stub
		
		
		Iterator<JsonVisite> iterator1 = l.iterator();
		Iterator<JsonVisite> iterator = l.iterator();
		
		
		 if (!iterator1.hasNext()){
			 return false;
		 }
		 
		 
		 JsonVisite j= iterator1.next();
		User user=userrepository.findOne(j.getIdUser());
		Patient patient=patientrepository.findOne(j.getIdPatient()) ;
		Dossier_patient dos =  dossier_patientrepository.findByPatient(patient);
		String rapport=j.getRapport();
		
		Visite visite=	new Visite();
		visite.setDate_fin(new Date());
		visite.setDossier_patient(dos);
		visite.setRapport(rapport);
		visite.setUser(user);	
		
		Visite v=visiterepository.save(visite);
		
		Facture f= new Facture();
		f.setEtat("non payée");
		long montant=50;
		f.setMontant(montant);
		f.setDate_edition(new Date());
		 Random randomno = new Random();
	     
		   // get next long value 
		    long num =   (long) Math.abs(randomno.nextInt());
		    
		f.setNum_fac(num);
		
		f.setTypeFacture("medecin");
		f.setVisite(v);
		facturerepository.save(f);
	
		
		
		
		Ordonnance or = new Ordonnance();
		or.setDate_ord(new Date());
		or.setVisite(v);
		Ordonnance ord = ordonnancerepository.save(or);
		
		v.setOrdonnances(ord);
		visiterepository.save(v);		
		
		while ( iterator.hasNext() ) {
			JsonVisite p = iterator.next();
		
		
			
			Medicaments m=   medicamentsrepository.findByNom(p.getNom());
			
			Prescription2   p1= new Prescription2();
			p1.setForm_med(p.getFormMed());
			p1.setMedicaments(m);
			p1.setNbr_fois_med(p.getNbrFoisMed());
			
			p1.setQuant_med(p.getQuantMed());
			p1.setOrdonnance(ord);
			prescription2repository.save(p1);
			
			
		}
			
		rendez_vousrepository.delete(j.getIdRdv());
	
		
		return true;
	}
	@Override
	public List<JsonVisite> chargerdetails(Long id_visite) {
		Visite v = visiterepository.findOne(id_visite);
		List<JsonVisite> list1= new  ArrayList<JsonVisite>();
		List<Prescription2> l=(List<Prescription2>) v.getOrdonnances().getPrescription2();
		Iterator<Prescription2> iterator = l.iterator();  
		  while ( iterator.hasNext() ) {
			  Prescription2 p = iterator.next();
			  JsonVisite json= new JsonVisite();
			  json.setRapport(v.getRapport());
			  json.setFormMed(p.getForm_med());
			  json.setNbrFoisMed(p.getNbr_fois_med());
			  json.setQuantMed(p.getQuant_med());
			  json.setNom(p.getMedicaments().getNom());
			
				 
			  list1.add(json) ;
		  }
			  
		
			return list1;
	}
	@Override
	@Transactional
	public List<JsonOrdonnancePharmacien> chargerordonnancepharmacien(Long id_visite) {
		
		Visite v = visiterepository.findOne(id_visite);
		List<JsonOrdonnancePharmacien> list1= new  ArrayList<JsonOrdonnancePharmacien>();
		List<Prescription2> l=(List<Prescription2>) v.getOrdonnances().getPrescription2();
		Iterator<Prescription2> iterator = l.iterator();
		
		 while ( iterator.hasNext() ) {
			  Prescription2 p = iterator.next();
			  JsonOrdonnancePharmacien json= new JsonOrdonnancePharmacien();
			  
			  json.setFormMed(p.getForm_med());
			  json.setNbrFoisMed(p.getNbr_fois_med());
			  json.setQuantMed(p.getQuant_med());
			  json.setNom(p.getMedicaments().getNom());
		   //
			 int x=(p.getMedicaments().getNbr()-p.getQuant_med());
			  //
			  if(  x >=0  )
			  {
				  json.setEtat("disponible");
			  }
			  else{
				  json.setEtat("non disponible");
			  }
			  
			  list1.add(json) ;
	}
		
		return  list1;
	}
	@Override
	@Transactional
	public int [] statvisite() {
		// TODO Auto-generated method stub
	
		List<Visite> list=visiterepository.findAll();
		Iterator<Visite> iterator = list.iterator();

int Nombres[] = { 0,0,0,0,0,0,0,0,0,0,0,0 }; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List <Date> listedate=new  ArrayList<Date>();
		Date d;
		Date d1;
		Date d2;
		Date d3;
		Date d4;
		Date d5;
		Date d6;
		try {
			d = sdf.parse("2017-01-01");
			listedate.add(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			d1 = sdf.parse("2017-02-01");
			listedate.add(d1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			d2 = sdf.parse("2017-03-01");
			listedate.add(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			d3 = sdf.parse("2017-04-01");
			listedate.add(d3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			d4 = sdf.parse("2017-05-01");
			listedate.add(d4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			d5 = sdf.parse("2017-06-01");
			listedate.add(d5);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			d6 = sdf.parse("2017-07-01");
			listedate.add(d6);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println(Nombres);
		System.out.println(Nombres[6]);
		
		
		
		while ( iterator.hasNext() ) {
			 Visite v = iterator.next();
		Date date=	 v.getDate_fin();
		Iterator<Date> iterator1 = listedate.iterator();  
		int i=-1;
			 Date date1 = iterator1.next();
		
		while ( iterator1.hasNext() ) {
			 Date date2 = iterator1.next();	 
			 
			 i++;
			 System.out.println(i ); 
			 System.out.println(date1);
			 System.out.println(date);
			 System.out.println(date2); 
			 if (date1.compareTo(date ) * date2.compareTo(date ) < 0) {         
				// traitement du cas date1 < date2 
				String x="Masculin";
				 if( x.equals(v.getDossier_patient().getPatient().getSex())  )
				 {
					 
			//		System.out.print(Nombres[1][i] ); 
					System.out.println("rajel" ); 
				 
					Nombres[i]++;
				 }
				 
				 else{
				//	 System.out.print(Nombres[2][i] ); 
					 Nombres[i+6]++;
					 System.out.println("mra" ); 
				 }
				 
			
				
			     } 

				if (date1.compareTo(date ) == 0){    
				// traitement du cas date1 = date2 
				
					String x="Masculin";
					 if( x.equals(v.getDossier_patient().getPatient().getSex())  )
					 {
						 
					//	 System.out.print(Nombres[1][i] ); 
						// System.out.print(i ); 
						 Nombres[i]++;
					 }
					 
					 else{
						// System.out.print(Nombres[2][i] ); 
						// System.out.print(i ); 
						 Nombres[i+6]++;
					 }
				
				
				} 
	      	if (date2.compareTo(date ) == 0 )   {
				// traitement du cas date1 = date2 
			
	      		String x="Masculin";
				 if( x.equals(v.getDossier_patient().getPatient().getSex())  )
				 {
					 
					// System.out.print(Nombres[1][i] ); 
					 Nombres[i]++;
				 }
				 
				 else{
				//	 System.out.print(Nombres[2][i] ); 
					 Nombres[i+6]++;
				 }
	      	
	      	} 
		
			

			 date1=date2;
			
			 
			 
			 
		}
			 
		}	 
		
		for(int j = 0; j < 12; j++)
		  {
		    System.out.print(Nombres[j]);
		    System.out.print("");
		    
		  }
		  
			System.out.println(Nombres);
		return Nombres;
		    }
	@Override
	@Transactional
	public List<JsonOrdonnance> chargerordonnancepharmacien1(Long id_visite) {
		Visite v = visiterepository.findOne(id_visite);
		List<JsonOrdonnance> list1= new  ArrayList<JsonOrdonnance>();
		List<Prescription2> l=(List<Prescription2>) v.getOrdonnances().getPrescription2();
		Iterator<Prescription2> iterator = l.iterator();
		
		 while ( iterator.hasNext() ) {
			  Prescription2 p = iterator.next();
			  JsonOrdonnance json= new JsonOrdonnance();
			  
			  json.setFormMed(p.getForm_med());
			  json.setNbrFoisMed(p.getNbr_fois_med());
			  json.setQuantMed(p.getQuant_med());
			  json.setNom(p.getMedicaments().getNom());
		   json.setPrixUnitaire(p.getMedicaments().getPrix());
			  //
			  if( p.getMedicaments().getNbr() > 0     )
			  {
				  json.setEtat("disponible");  
				  int x=(p.getMedicaments().getNbr()-p.getQuant_med());
				  if(  x >=0  ){
					  json.setQuantmax(p.getQuant_med()); 
					  json.setQuantprise(p.getQuant_med());
				  }	  
				  else{
					  json.setQuantmax(p.getMedicaments().getNbr()); 
					  json.setQuantprise(p.getMedicaments().getNbr());
				  }
				  
			  
			  }
			  else 
			  {
				  
				  json.setEtat("non disponible");
				  json.setQuantmax(0);
				  json.setQuantprise(0); 
			  }
				  
			 
			  json.setCheck(false);
			 
			  
			  list1.add(json) ;
	}
		
		return  list1;
	}
			 
			 
		
		
		
		
	

	
	
}
