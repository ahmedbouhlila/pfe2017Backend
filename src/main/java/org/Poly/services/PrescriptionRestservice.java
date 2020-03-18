package org.Poly.services;

import java.util.List;

import org.Poly.entities.Ordonnance_type;
import org.Poly.entities.Patient;
import org.Poly.entities.Prescription1;
import org.Poly.metier.PrescriptionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PrescriptionRestservice {

	@Autowired
	public PrescriptionMetier prescriptionmetier;
	
	
	@Secured({"ROLE_admin","ROLE_medecin"})
	@RequestMapping(value="/prescriptions1",method=RequestMethod.GET)	
	public List<Prescription1> listPrescription1() {
		return  prescriptionmetier.listPrescription1() ;
	}
	
	
	@RequestMapping(value="/ajoutlistprescription1",method=RequestMethod.POST)
	public List<Prescription1> saveListPrescription1( @RequestBody List<Prescription1> l) {
		return  prescriptionmetier.savelistPrescription1(l)  ;
	}

	
	
}
