package org.Poly.metier;

import java.util.List;

import org.Poly.Json.JsonPrescription;
import org.Poly.entities.Medicaments;
import org.Poly.entities.Ordonnance_globale;
import org.Poly.entities.Ordonnance_type;
import org.Poly.entities.Prescription1;

public interface OrdonnanceMetier {
	public List<Ordonnance_type> listordonnancetype( Long id_medecin   );
	
	public Ordonnance_type saveordonnancetype( Ordonnance_type o );
	
	public  Boolean saveordonnancetype(List<JsonPrescription> l);
	
	public List<JsonPrescription> chargerordonnancetype( Long idOrdonnance );
	
	public List<Ordonnance_globale> listordonnanceglobale( );
	
	public List<JsonPrescription> chargerordonnanceglobale( Long idOrdonnanceglobale );

	public  Boolean saveordonnanceGlobale(List<JsonPrescription> l);
	
	public Boolean effacerordonnancetype(Long idOrdonnance);
	
	public Boolean modifierordonnancetype(List<JsonPrescription> l,Long idordonnance, String nom);

	
}
