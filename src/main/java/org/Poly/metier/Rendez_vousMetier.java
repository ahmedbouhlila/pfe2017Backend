package org.Poly.metier;

import java.util.Date;
import java.util.List;

import org.Poly.Json.JsonRendez_Vous2;
import org.Poly.entities.Rendez_vous;


public interface Rendez_vousMetier {

	public List<Rendez_vous> listRendez_vous();	
	
	public Rendez_vous createRendez_vous(Long id_creneaux, Long id_patient , String jour, Long id_user );
	
	public List<Rendez_vous> listRendez_vousPatient(Long id_patient);	
	
	public void effacerRendezVous(Long id_rendez_vous);	
	
	public List<JsonRendez_Vous2> listRendez_vousAdmin();	
	
}
