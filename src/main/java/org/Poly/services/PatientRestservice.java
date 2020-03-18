package org.Poly.services;

import java.util.List;

import org.Poly.entities.Medicaments;
import org.Poly.entities.Patient;
import org.Poly.metier.MedicamentsMetier;
import org.Poly.metier.PatientMetier;
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
public class PatientRestservice {

	@Autowired
	private PatientMetier patientMetier;

	@Secured({ "ROLE_admin", "ROLE_secretaire" })
	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public Patient savePatient(@RequestBody Patient pe) {
		return patientMetier.savePatient(pe);
	}

	@Secured({ "ROLE_admin", "ROLE_secretaire" })
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public List<Patient> listPatient() {
		return patientMetier.listPatient();
	}

	@Secured("ROLE_admin")
	@RequestMapping(value = "/effacerpatient/{id_patient}", method = RequestMethod.DELETE)

	public void deleteUser(@PathVariable Long id_patient) {
		patientMetier.effacerPatient(id_patient);

	}

	@Secured({ "ROLE_admin", "ROLE_secretaire", "ROLE_pharmacien" })
	@RequestMapping(value = "/identifierpatient", method = RequestMethod.PUT)
	public List<Patient> loadPatient(@RequestParam Long cin) {
		return patientMetier.loadPatient(cin);
	}
	//

	@RequestMapping(value = "/chargerpatient", method = RequestMethod.PUT)
	public Patient chargerPatient(@RequestParam Long id_patient) {
		return patientMetier.chargerPatient(id_patient);
	}

	//

	@Secured({ "ROLE_admin", "ROLE_secretaire" })
	@RequestMapping(value = "/modifierpatient", method = RequestMethod.POST)
	public void modifierPatient(@RequestBody Patient pe) {

		patientMetier.modifierPatient(pe);

	}

}
