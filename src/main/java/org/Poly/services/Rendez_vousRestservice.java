package org.Poly.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.Poly.Json.JsonRendez_Vous;
import org.Poly.Json.JsonRendez_Vous1;
import org.Poly.Json.JsonRendez_Vous2;
import org.Poly.entities.Creneaux;
import org.Poly.entities.Patient;
import org.Poly.entities.Rendez_vous;
import org.Poly.entities.User;
import org.Poly.metier.CreneauxMetier;
import org.Poly.metier.Rendez_vousMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Rendez_vousRestservice {
	@Autowired
	private Rendez_vousMetier rendez_vousmetier;
	@Autowired
	private CreneauxMetier creneauxmetier;
	
	
	
	@Secured({"ROLE_admin","ROLE_secretaire"})
	@RequestMapping(value="/rendez_vous",method=RequestMethod.GET)	
	public List<Rendez_vous> listRendez_vous() {
		return rendez_vousmetier.listRendez_vous() ;
	}
	
	@Secured({"ROLE_admin","ROLE_secretaire"})
	@RequestMapping(value="/ajoutrendez_vous",method=RequestMethod.PUT)
	public    Rendez_vous   createRendez_vous(@RequestParam Long id_creneaux,@RequestParam Long id_patient,@RequestParam String jour,@RequestParam Long id_user) {
		return rendez_vousmetier.createRendez_vous(id_creneaux, id_patient, jour,id_user) ;
	}
	
	@Secured({"ROLE_admin","ROLE_secretaire"})
	@RequestMapping(value="/rendez_vouspatient",method=RequestMethod.PUT)
	public   List<JsonRendez_Vous>   listRendez_vousPatient(@RequestParam Long id_patient) {
		
		List<JsonRendez_Vous> list= new  ArrayList<JsonRendez_Vous>();
		
		List<Rendez_vous> listrendez=null;
		System.out.println("aaa");
		  System.out.println(rendez_vousmetier.listRendez_vousPatient(id_patient));  
		System.out.println("bbbb");
		listrendez= rendez_vousmetier.listRendez_vousPatient(id_patient) ;
		System.out.println(listrendez);
		System.out.println("cccc");
		
		Iterator<Rendez_vous> iterator = listrendez.iterator();
		
		
		while ( iterator.hasNext() ) {
			Rendez_vous o = iterator.next();
			
			JsonRendez_Vous j=new JsonRendez_Vous();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
	        String date1 = sdf.format(o.getJour());
			
			j.setJour(date1);
			j.setHdebut(o.getCreneaux().getHdebut());
			j.setHfin(o.getCreneaux().getHfin());
		    j.setMdebut(o.getCreneaux().getMdebut());
		    j.setMfin(o.getCreneaux().getMfin());
		
		j.setNom(o.getCreneaux().getUser().getNom());
		j.setPrenom(o.getCreneaux().getUser().getPrenom());
		j.setType_medecin(o.getCreneaux().getUser().getType_medecin());
		j.setId_rendez_vous(o.getId_rendez_vous());
	       System.out.println("bbbua"); 
	        System.out.println(j);  
	        
	        
		list.add(j);
		 System.out.println("bbbu"); 
	        System.out.println(list);  
		}
		
       
		
		
		
		
		
	   return list;
	
	} 
	
	 @RequestMapping(value = "/supprimerrendez_vous/{id_rendez_vous}", method = RequestMethod.DELETE)
	    
	    public void delete(@PathVariable long id_rendez_vous) {
	           
		 rendez_vousmetier.effacerRendezVous(id_rendez_vous);
	 
	 }
	 
	//
	 @Secured({"ROLE_admin","ROLE_medecin"})
		@RequestMapping(value="/rendez_vousmedecin1",method=RequestMethod.PUT)
		public   List<JsonRendez_Vous1>   listRendez_vousMedecin1(@RequestParam Long id_medecin)	
		
		
		{
			List<JsonRendez_Vous1> list= new  ArrayList<JsonRendez_Vous1>();            
		 List<Creneaux>  	listCreneaux=creneauxmetier.listCreneauxDuMedecin(id_medecin);
		 Iterator<Creneaux> iterator = listCreneaux.iterator();
		 
		 while ( iterator.hasNext() ) {
				Creneaux c = iterator.next();
				
				 int Hdebut=c.getHdebut();
				int Hfin=c.getHfin();
				 int Mdebut=c.getMdebut();
				 int Mfin=c.getHfin();	
			List<Rendez_vous> listrendez_vous=(List<Rendez_vous>) c.getRendez_vous();	
			 Iterator<Rendez_vous> iterator1=listrendez_vous.iterator();
			 while ( iterator1.hasNext() ) {
					Rendez_vous r = iterator1.next();	 
				JsonRendez_Vous1 j=new JsonRendez_Vous1();	
		 j.setHdebut(Hdebut);
		 j.setHfin(Hfin);
		 j.setId_patient(r.getPatient().getId_patient());
		 j.setIdRdv(r.getId_rendez_vous());
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String date1 = sdf.format(r.getJour());
			
			j.setJour(date1);
		 j.setMdebut(Mdebut);
		 j.setMfin(Mfin);
		 j.setNom_patient(r.getPatient().getNom_patient());
		 j.setPrenom_patient(r.getPatient().getPrenom_patient());
		 list.add(j); 
			 }
		 }
			
		
		 
		 Collections.sort(list, new Comparator<JsonRendez_Vous1>() {
			    public int compare(JsonRendez_Vous1 m1, JsonRendez_Vous1 m2) {
			        return m1.getJour().compareTo(m2.getJour());
			    }
			}); 
		 
		 
			return list;
		}
		
		
	 
	 
	 //
	 @Secured({"ROLE_admin","ROLE_medecin"})
		@RequestMapping(value="/rendez_vousmedecin",method=RequestMethod.PUT)
		public   List<JsonRendez_Vous1>   listRendez_vousMedecin(@RequestParam Long id_medecin)	
		
		
		{
			List<JsonRendez_Vous1> list= new  ArrayList<JsonRendez_Vous1>();            
		 List<Creneaux>  	listCreneaux=creneauxmetier.listCreneauxDuMedecin(id_medecin);
		 Iterator<Creneaux> iterator = listCreneaux.iterator();
		 
		 while ( iterator.hasNext() ) {
				Creneaux c = iterator.next();
				
				 int Hdebut=c.getHdebut();
				int Hfin=c.getHfin();
				 int Mdebut=c.getMdebut();
				 int Mfin=c.getHfin();	
			List<Rendez_vous> listrendez_vous=(List<Rendez_vous>) c.getRendez_vous();	
			 Iterator<Rendez_vous> iterator1=listrendez_vous.iterator();
			 while ( iterator1.hasNext() ) {
					Rendez_vous r = iterator1.next();	 
				JsonRendez_Vous1 j=new JsonRendez_Vous1();	
		 j.setHdebut(Hdebut);
		 j.setHfin(Hfin);
		 j.setId_patient(r.getPatient().getId_patient());
		 j.setIdRdv(r.getId_rendez_vous());
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
	        String date1 = sdf.format(r.getJour());
			
			j.setJour(date1);
		 j.setMdebut(Mdebut);
		 j.setMfin(Mfin);
		 j.setNom_patient(r.getPatient().getNom_patient());
		 j.setPrenom_patient(r.getPatient().getPrenom_patient());
		 list.add(j); 
			 }
		 }
			
		
		 
		 Collections.sort(list, new Comparator<JsonRendez_Vous1>() {
			    public int compare(JsonRendez_Vous1 m1, JsonRendez_Vous1 m2) {
			        return m1.getJour().compareTo(m2.getJour());
			    }
			}); 
		 
		 
			return list;
		}
		
		
	 
		@Secured({"ROLE_admin","ROLE_secretaire"})
		@RequestMapping(value="/listrendez_vous",method=RequestMethod.GET)	
		public List<JsonRendez_Vous2> listRendez_vousadmin() {
			return rendez_vousmetier.listRendez_vousAdmin();
		} 
	
	
	}	

