package org.Poly.services;

import java.util.List;

import org.Poly.Json.JsonDossierPatient;
import org.Poly.metier.DossierPatientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DossierPatientRestservice {
	@Autowired
	private DossierPatientMetier dossier_patientMetier;

	@Secured({ "ROLE_admin", "ROLE_medecin", "ROLE_pharmacien" })
	@RequestMapping(value = "/chargerdossier_patient", method = RequestMethod.PUT)
	public List<JsonDossierPatient> chargerdossier_patient(@RequestParam Long id_patient) {
		return dossier_patientMetier.chargerdossier_patient(id_patient);
	}
}
