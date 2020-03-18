package org.Poly.metier;

import java.util.Date;
import java.util.List;

import org.Poly.entities.Creneaux;

public interface CreneauxMetier {
	
	public List<Creneaux> listCreneaux();
	public List<Creneaux> listCreneauxMedecin(Long id_medecin, String date);
	public List<Creneaux> listCreneauxDuMedecin(Long id_medecin);
	
	public List<Creneaux> listCreneauxMed(Long id_medecin);
	
}
