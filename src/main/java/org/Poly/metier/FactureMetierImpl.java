package org.Poly.metier;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.Poly.Json.JsonFacture;
import org.Poly.Json.JsonOrdonnancePharmacien;
import org.Poly.dao.Dossier_patientRepository;
import org.Poly.dao.FactureRepository;
import org.Poly.dao.MedicamentsRepository;
import org.Poly.dao.PatientRepository;
import org.Poly.dao.RoleRepository;
import org.Poly.dao.UserRepository;
import org.Poly.dao.VisiteRepository;
import org.Poly.entities.Facture;
import org.Poly.entities.Medicaments;
import org.Poly.entities.Prescription2;
import org.Poly.entities.Role;
import org.Poly.entities.User;
import org.Poly.entities.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.Poly.Json.JsonOrdonnance;

@Service
public class FactureMetierImpl implements FactureMetier {

	@Autowired
	MedicamentsRepository medicamentsrepository;
	@Autowired
	VisiteRepository visiterepository;
	@Autowired
	FactureRepository facturerepository;
	@Autowired
	PatientRepository patientrepository;
	@Autowired
	Dossier_patientRepository dossier_patientrepository;
	@Autowired
	UserRepository userrepository;
	@Autowired
	RoleRepository rolerepository;
	
	@Override
	@Transactional
	public List<JsonOrdonnancePharmacien> chargerordonnancepharmacien(List<JsonOrdonnancePharmacien>Json) {
		List<JsonOrdonnancePharmacien>  list = new  ArrayList<JsonOrdonnancePharmacien>();
		
		
		Iterator<JsonOrdonnancePharmacien> iterator = Json.iterator();
		
		 while ( iterator.hasNext() ) {
			 
		 
		 JsonOrdonnancePharmacien j = iterator.next();
		    if( j.getEtat() == "disponible"  )
		    {
		    	JsonOrdonnancePharmacien p = new JsonOrdonnancePharmacien();
		    	p.setFormMed(j.getFormMed());
		    	p.setNbrFoisMed(j.getNbrFoisMed());
		    	p.setNom(j.getNom());
		       	p.setQuantMed(j.getQuantMed());
		    p.setPrixUnitaire(medicamentsrepository.findByNom(j.getNom()).getPrix());
		    	p.setPrixTotale(j.getQuantMed()*p.getPrixUnitaire() );
		    	
		    	
		    	list.add(p);
		    }
		    
		    
		    else {
		    	
		    }
		 
		 
		
		 }
		return list;
	}

	@Override
	@Transactional
	public Boolean saveFacture(float montant, Long id_visite,List<JsonOrdonnance> list) {
		// TODO Auto-generated method stub
		int x=222;
		int y=22552;
		
		Visite v=visiterepository.findOne(id_visite);
		Facture f = new Facture();
		f.setAdresse_etab("");
		
		
		f.setDate_edition(new Date());
		f.setEtablissement("");
		f.setEtat("non payée");
		f.setTypeFacture("pharmacien");
		f.setNom_preparateur("");
		
		 Random randomno = new Random();
	     
		   // get next long value 
		    long num =   (long) Math.abs(randomno.nextInt());
		    
		f.setNum_fac(num);
		
		f.setNum_fax((long) x);
		f.setNum_tel((long) y);
		f.setPrenom_preparateur("");
	f.setMontant(montant);
		f.setVisite(v);
		
		facturerepository.save(f);
		
		Iterator<JsonOrdonnance> iterator = list.iterator();
		 while ( iterator.hasNext() ) {
			 
			 
			 JsonOrdonnance json = iterator.next();	
		
		Medicaments m=	 medicamentsrepository.findByNom(json.getNom());
		int nbr=(m.getNbr()-json.getQuantprise());
			 m.setNbr(nbr);
			 medicamentsrepository.save(m);	 
			 
		 }
		
		return true;
	}

	@Override
	@Transactional
	public List<JsonFacture> getfacture(Long id_patient) {
		// TODO Auto-generated method stub
		
		List<JsonFacture>  list= new  ArrayList<JsonFacture>();
		 
		List <Visite> list1= (List <Visite>)patientrepository.findOne(id_patient).getDossier_patient().getVisites();
		
		Iterator<Visite> iterator = list1.iterator();
		
		 while ( iterator.hasNext() ) {
			 
		 
		 Visite v = iterator.next();	
		
		       List<Facture> list2= (List<Facture>)v.getFactures();
				 Iterator<Facture> iterator1 = list2.iterator(); 
		       while ( iterator1.hasNext() ) {
					 
		  		 
		  		 Facture fac = iterator1.next();	
		  String x ="non payée";
		  		 
		 if(x.equals(fac.getEtat()))
			{JsonFacture jsonfacture = new JsonFacture();
			jsonfacture.setAdresse_etab(fac.getAdresse_etab());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
	        String date1 = sdf.format(fac.getDate_edition());
			jsonfacture.setDate_edition(date1);
			jsonfacture.setEtablissement(fac.getEtablissement());
			jsonfacture.setEtat(fac.getEtat());
			jsonfacture.setId_facture(fac.getId_facture());
			jsonfacture.setNom_preparateur(fac.getNom_preparateur());
			jsonfacture.setNum_fac(fac.getNum_fac());
			jsonfacture.setNum_fax(fac.getNum_fax());
			jsonfacture.setNum_tel(fac.getNum_tel());
			jsonfacture.setPrenom_preparateur(fac.getPrenom_preparateur());
			jsonfacture.setRib_banque(fac.getRib_banque());
			jsonfacture.setTypeFacture(fac.getTypeFacture());
			jsonfacture.setMontant(fac.getMontant());
			
			
			 list.add(jsonfacture);
			 
			
			
			
			}
		 
		  
		 
		       }
		       
		 }
		 
		 if( list.size() >0 )
		 { Collections.sort(list, new Comparator<JsonFacture>() {
			    public int compare(JsonFacture m1, JsonFacture m2) {
			        return m1.getTypeFacture().compareTo(m2.getTypeFacture());
			    }
			}); 
		 }
		return list;
	}

	@Override
	@Transactional
	public Boolean payerfacture(List<JsonFacture> list,Long id_secretaire) {
		
		List<JsonFacture>  list1= new  ArrayList<JsonFacture>();
		List<JsonFacture>  list2= new  ArrayList<JsonFacture>();
		list1=list;
		list2=list;
		Iterator<JsonFacture> iterator1 = list1.iterator();
		Iterator<JsonFacture> iterator2 = list2.iterator();
		 String etablissement;
		 String adresse_etab;
		 Long num_tel;
		 Long num_fax;
		 String prenom_preparateur;  
		 String nom_preparateur;
		String typepayement;
		
		
		if( iterator1.hasNext()  )
		{
			JsonFacture fac = iterator1.next();	
			  etablissement=fac.getEtablissement();
			  adresse_etab=fac.getAdresse_etab();
			 num_tel=fac.getNum_tel();
			  num_fax=fac.getNum_fax();
			 
			  nom_preparateur=fac.getNom_preparateur();
			  prenom_preparateur=fac.getPrenom_preparateur(); 	
			typepayement=fac.getTypepayement();
			
		}	
		else{
			
		return false;
		
		}
			
			
		while ( iterator2.hasNext() ) {
				 
		  		 
		  		 JsonFacture facjson = iterator2.next();	
		 Facture facture=facturerepository.findOne(facjson.getId_facture());
		facture.setAdresse_etab(adresse_etab);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			d = sdf.parse(facjson.getDate_edition());
			
			facture.setDate_edition(d);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		facture.setEtablissement(etablissement);
		facture.setEtat("payée");
		facture.setId_facture(facjson.getId_facture());
		facture.setMontant(facjson.getMontant());
		facture.setNom_preparateur(nom_preparateur);
		facture.setNum_fac(facjson.getNum_fac());
		facture.setNum_fax(num_fax);
		facture.setNum_tel(num_tel);
		facture.setPrenom_preparateur(prenom_preparateur);
		facture.setRib_banque(facjson.getRib_banque());
		facture.setTypeFacture(facjson.getTypeFacture());
		facture.setTypepayement(typepayement);
		facture.setIdsecretaire(id_secretaire);
		facturerepository.save(facture);
		
	}

		return true;
	
	}

	@Override
	@Transactional
	public float[] statfacture() {
		
		List<Facture> list=facturerepository.findAll();
		Iterator<Facture> iterator = list.iterator();

float Nombres[] = { 0,0,0,0,0,0,0,0,0,0,0,0 }; 
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
		while ( iterator.hasNext() ) {
			 Facture f = iterator.next();
		Date date=	 f.getDate_edition();
		Iterator<Date> iterator1 = listedate.iterator();  
		int i=-1;
			 Date date1 = iterator1.next();
		
		while ( iterator1.hasNext() ) {
			 Date date2 = iterator1.next();	 
			 i++;			 
			 if (date1.compareTo(date ) * date2.compareTo(date ) < 0) {         
				// traitement du cas date1 < date2 
				 String x="payée";
				 if( x.equals(f.getEtat())  )
				 {
				 String y="medecin";
				 
				 if( y.equals(f.getTypeFacture())  )
				 {
					 
			//		
				 
					Nombres[i]+=f.getMontant();
				 }
				 
				 else{
			
					 Nombres[i+6]+=f.getMontant();
					 
				 }
				 
				 
				 }
			 }
				 
			 if (date1.compareTo(date ) == 0){    
					// traitement du cas date1 = date2 
					
				 String x="payée";
				 if( x.equals(f.getEtat())  )
				 {
				 String y="medecin";
				 
				 if( y.equals(f.getTypeFacture())  )
				 {
					 
			//		
				 
					Nombres[i]+=f.getMontant();
				 }
				 
				 else{
			
					 Nombres[i+6]+=f.getMontant();
					 
				 }
				 
				 
				 }		
					
					} 
		      	if (date2.compareTo(date ) == 0 )   {
					// traitement du cas date1 = date2 
				
		      		 String x="payée";
					 if( x.equals(f.getEtat())  )
					 {
					 String y="medecin";
					 
					 if( y.equals(f.getTypeFacture())  )
					 {
						 
				//		
					 
						Nombres[i]+=f.getMontant();
					 }
					 
					 else{
				
						 Nombres[i+6]+=f.getMontant();
						 
					 }
					 
					 
					 }
		      	}
			 
			 

				 date1=date2;
				
				 
				 
				 
			}
				 
			}	 
		
		return Nombres;
	}
	
	
	@Override
	@Transactional
	public List[] caisseFacture(String date1, String date2) {
		List<String>  list1= new  ArrayList<String>();
		List<Float>  list2= new  ArrayList<Float>();
		Role role =rolerepository.findOne((long)1);
		List<User> secretaires = userrepository.findByRole(role);
		Iterator<User> iterator1 = secretaires.iterator();  
		
		
		while ( iterator1.hasNext() ) {
			User secretaire = iterator1.next();	 
		
	List <Facture> factures=	facturerepository.findByIdsecretaireAndEtat(secretaire.getId_user(),"payée");
	Iterator<Facture> iterator2 = factures.iterator();  
	
	float somme=0 ; 
	while ( iterator2.hasNext() ) {
		Facture facture= iterator2.next();
	//(d.compareTo( r.getJour()) * d1.compareTo(r.getJour() ) < 0)||(r.getJour().compareTo(d ) == 0) ||(r.getJour().compareTo(d1 ) == 0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date() ;
		Date d1 = new Date() ;
		try {
			d = sdf.parse(date1);
			d1 = sdf.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if((d.compareTo( facture.getDate_edition()) * d1.compareTo(facture.getDate_edition() ) < 0)||(facture.getDate_edition().compareTo(d ) == 0) ||(facture.getDate_edition().compareTo(d1 ) == 0))
		{
		
		 somme  = somme + facture.getMontant(); ;
		
		
		
		
		
		
		
		
		
	}
		
	}
	
	
	if(somme>0)
		{list1.add(secretaire.getNom()+" "+secretaire.getPrenom());
		
		list2.add(somme);}
	//	
		
		
		
		
		
		}			
		
		
		
		
		
		
		
		
		return new List []{ list1 , list2};
	}

	

	

	
	
}
