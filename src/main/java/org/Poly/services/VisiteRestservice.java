package org.Poly.services;


import java.util.List;

import org.Poly.Json.JsonOrdonnance;
import org.Poly.Json.JsonOrdonnancePharmacien;
import org.Poly.Json.JsonVisite;
import org.Poly.entities.Visite;
import org.Poly.metier.VisiteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VisiteRestservice {

	@Autowired
	private VisiteMetier visiteMetier;
	
	@RequestMapping(value="/visites",method=RequestMethod.GET)
	public List<Visite> listVisite() {
		return visiteMetier.listVisite();
	}
	
	
	@RequestMapping(value="/ajoutervisite",method=RequestMethod.POST)
	public Boolean ajouterVisite(@RequestBody List<JsonVisite> l) {
		return visiteMetier.ajoutvisite(l);
	}
	
	@Secured({"ROLE_admin","ROLE_medecin","ROLE_pharmacien"})
	@RequestMapping(value="/chargerdetails",method=RequestMethod.PUT)
	public List<JsonVisite> chargerdetails(@RequestParam  Long id_visite) {
		return visiteMetier.chargerdetails(id_visite) ;
	}

	@Secured({"ROLE_admin","ROLE_medecin","ROLE_pharmacien"})
	@RequestMapping(value="/chargerdetailsordonnance",method=RequestMethod.PUT)
	public List<JsonOrdonnancePharmacien> chargerordonnancepharmacien(@RequestParam  Long id_visite) {
		return visiteMetier.chargerordonnancepharmacien(id_visite) ;
	}

	//
	@Secured({"ROLE_admin","ROLE_medecin","ROLE_pharmacien"})
	@RequestMapping(value="/chargerdetailsordonnance1",method=RequestMethod.PUT)
	public List<JsonOrdonnance> chargerordonnancepharmacien1(@RequestParam  Long id_visite) {
		return visiteMetier.chargerordonnancepharmacien1(id_visite) ;
	}

	
	//
	@RequestMapping(value="/statvisites",method=RequestMethod.GET)
	public int [] statvisite() {
		return visiteMetier.statvisite();
	}
	
	

}
