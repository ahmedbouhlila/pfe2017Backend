package org.Poly.metier;

import java.util.List;

import org.Poly.Json.JsonFacture;
import org.Poly.Json.JsonOrdonnance;
import org.Poly.Json.JsonOrdonnancePharmacien;
import org.Poly.entities.Facture;

public interface FactureMetier {

	List<JsonOrdonnancePharmacien> chargerordonnancepharmacien( List<JsonOrdonnancePharmacien> Json );	
	 Boolean saveFacture( float montant , Long id_visite,List<JsonOrdonnance> list );
	List <JsonFacture> getfacture(Long id_patient );
	 Boolean  payerfacture(List <JsonFacture> list , Long id_secretaire);
	 float [] statfacture ();
	 List <String>[] caisseFacture (String date1 ,String date2 );
}
