package org.Poly.metier;

import java.util.List;

import org.Poly.Json.JsonOrdonnance;
import org.Poly.Json.JsonOrdonnancePharmacien;
import org.Poly.Json.JsonVisite;
import org.Poly.entities.Visite;

public interface VisiteMetier {

	public List<Visite> listVisite();
	
	public Boolean ajoutvisite(List <JsonVisite> l );
	List<JsonVisite> chargerdetails(Long id_visite);
	List<JsonOrdonnancePharmacien> chargerordonnancepharmacien(Long id_visite);
	int [] statvisite ();
	
	List<JsonOrdonnance> chargerordonnancepharmacien1(Long id_visite);
	
	
}
