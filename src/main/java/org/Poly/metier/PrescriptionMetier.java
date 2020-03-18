package org.Poly.metier;

import java.util.List;

import org.Poly.entities.Patient;
import org.Poly.entities.Prescription1;

public interface PrescriptionMetier {

	public List<Prescription1> listPrescription1();
	
	public List<Prescription1> savelistPrescription1(List<Prescription1> l);
	
	
}
