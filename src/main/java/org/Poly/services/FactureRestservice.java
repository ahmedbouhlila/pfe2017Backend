package org.Poly.services;

import java.util.List;

import org.Poly.Json.JsonFacture;
import org.Poly.Json.JsonOrdonnance;
import org.Poly.Json.JsonOrdonnancePharmacien;
import org.Poly.Json.JsonVisite;
import org.Poly.entities.Facture;
import org.Poly.entities.Medicaments;
import org.Poly.metier.FactureMetier;
import org.Poly.metier.VisiteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FactureRestservice {
	@Autowired
	private FactureMetier facturemetier;
	@Autowired
	private VisiteMetier visiteMetier;
	@RequestMapping(value="/validationOrdonnance",method=RequestMethod.PUT)
	public List<JsonOrdonnancePharmacien> validationordonnance(@RequestParam  Long id_visite) {
		return facturemetier.chargerordonnancepharmacien(visiteMetier.chargerordonnancepharmacien(id_visite));
	}
	
/*	
	@RequestMapping(value="/savefacture",method=RequestMethod.PUT)
	public Boolean savefacture (@RequestParam  float montant,@RequestParam  Long id_visite) {
		return facturemetier.saveFacture(montant, id_visite);
	}
	*/
	 @RequestMapping(value = "/savefacture/{montant}/{id_visite}", method = RequestMethod.POST)	    
	 public Boolean savefacture(@PathVariable Long montant,@PathVariable Long id_visite,@RequestBody List<JsonOrdonnance> list ) {
		return facturemetier.saveFacture(montant, id_visite, list);
	 }
	
	 
	//
	@RequestMapping(value="/getfacture",method=RequestMethod.PUT)
	public List<JsonFacture> getfacture (@RequestParam  Long id_patient) {
		return facturemetier.getfacture(id_patient);
	}
	
	@RequestMapping(value="/payerfacture/{id_secretaire}",method=RequestMethod.POST)
	public Boolean payerfacture(@RequestBody List<JsonFacture> list,@PathVariable Long id_secretaire)
	{
		return facturemetier.payerfacture(list,id_secretaire);
		
	}

	@RequestMapping(value="/statsfacture",method=RequestMethod.GET)
	public float [] statfacture()
	{
		return facturemetier.statfacture();
		
	}
	
	@RequestMapping(value="/caisse",method=RequestMethod.PUT)
	public List[]  caisseFacture (@RequestParam  String date1 ,@RequestParam String date2 ) {
		return  facturemetier.caisseFacture(date1, date2); 
		
}

}
