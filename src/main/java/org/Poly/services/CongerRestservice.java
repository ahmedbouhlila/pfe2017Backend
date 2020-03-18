package org.Poly.services;

import java.util.List;

import org.Poly.entities.Conger;
import org.Poly.metier.CongerMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CongerRestservice {
	@Autowired
	private CongerMetier congermetier;

	@RequestMapping(value = "/getconger", method = RequestMethod.PUT)
	public List<Conger> getconger(@RequestParam Long id_medecin) {

		return congermetier.listCongerMedecin(id_medecin);
	}

}
