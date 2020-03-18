package org.Poly.services;

import java.util.List;

import org.Poly.Json.JsonPrescription;
import org.Poly.entities.Ordonnance_globale;
import org.Poly.entities.Ordonnance_type;
import org.Poly.entities.Patient;
import org.Poly.entities.User;
import org.Poly.metier.MedicamentsMetier;
import org.Poly.metier.OrdonnanceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrdonnanceRestservice {

	@Autowired
	private OrdonnanceMetier ordonnanceMetier;

	@Secured({ "ROLE_admin", "ROLE_medecin" })
	@RequestMapping(value = "/ordonnancemedecin", method = RequestMethod.PUT)
	public List<Ordonnance_type> loadordonnance(@RequestParam Long id_medecin) {
		return ordonnanceMetier.listordonnancetype(id_medecin);
	}

	@RequestMapping(value = "/ajoutordonnance", method = RequestMethod.POST)
	public Ordonnance_type saveOrdonnance(@RequestBody Ordonnance_type o) {
		return ordonnanceMetier.saveordonnancetype(o);
	}

	@RequestMapping(value = "/ajoutordonnancetype", method = RequestMethod.POST)
	public Boolean saveOrdonnance(@RequestBody List<JsonPrescription> l) {
		return ordonnanceMetier.saveordonnancetype(l);
	}

	@RequestMapping(value = "/chargerordonnancetype", method = RequestMethod.PUT)
	public List<JsonPrescription> loadOrdonnance(@RequestParam Long idOrdonnance) {
		return ordonnanceMetier.chargerordonnancetype(idOrdonnance);
	}

	@RequestMapping(value = "/chargerordonnanceglobale", method = RequestMethod.GET)
	public List<Ordonnance_globale> loadOrdonnanceglobale() {
		return ordonnanceMetier.listordonnanceglobale();
	}

	@RequestMapping(value = "/chargerprescriptionglobale", method = RequestMethod.PUT)
	public List<JsonPrescription> loadPrescription(@RequestParam Long idOrdonnanceglobale) {
		return ordonnanceMetier.chargerordonnanceglobale(idOrdonnanceglobale);
	}

	@RequestMapping(value = "/ajoutordonnanceglobale", method = RequestMethod.POST)
	public Boolean saveOrdonnanceglobale(@RequestBody List<JsonPrescription> l) {
		return ordonnanceMetier.saveordonnanceGlobale(l);
	}

	@RequestMapping(value = "/supprimerordonnancetype/{id_ordonnance_type}", method = RequestMethod.DELETE)

	public Boolean deleteordonnancetype(@PathVariable long id_ordonnance_type) {

		return ordonnanceMetier.effacerordonnancetype(id_ordonnance_type);

	}

	@RequestMapping(value = "/modifierordonnancetype/{id_ordonnance_type}/{nom}", method = RequestMethod.POST)
	public Boolean modifierOrdonnance(@RequestBody List<JsonPrescription> l, @PathVariable long id_ordonnance_type,
			@PathVariable String nom) {
		return ordonnanceMetier.modifierordonnancetype(l, id_ordonnance_type, nom);
	}

}
