package org.Poly.metier;

import java.util.List;

import org.Poly.Json.JsonDossierPatient;

public interface DossierPatientMetier {

	List<JsonDossierPatient> chargerdossier_patient(Long id_patient);
	
	
}
