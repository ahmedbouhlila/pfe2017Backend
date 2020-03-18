package org.Poly.services;

import java.util.List;

import org.Poly.entities.Creneaux;
import org.Poly.metier.CreneauxMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CreneauxRestservice {

	@Autowired
	private CreneauxMetier creneauxMetier;

	@RequestMapping(value = "/creneaux", method = RequestMethod.GET)
	public List<Creneaux> listcreaneaux() {
		return creneauxMetier.listCreneaux();
	}

	@RequestMapping(value = "/getcreneaux", method = RequestMethod.PUT)
	public List<Creneaux> getcreneaux(@RequestParam Long id_medecin, @RequestParam String date)

	{

		return creneauxMetier.listCreneauxMedecin(id_medecin, date);
	}

	@RequestMapping(value = "/chargercreneaux", method = RequestMethod.PUT)
	public List<Creneaux> getcreneaux(@RequestParam Long id_medecin)

	{

		return creneauxMetier.listCreneauxMed(id_medecin);
	}

}
