package org.Poly.Json;

public class JsonOrdonnancePharmacien {
	private int nbrFoisMed ;

	private String formMed ;

	private int quantMed ;
	 private String  nom ;
	 private String etat;
	 private Long id;
	 private float prixUnitaire;
	 private float prixTotale; 
	 
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public float getPrixTotale() {
		return prixTotale;
	}
	public void setPrixTotale(float prixTotale) {
		this.prixTotale = prixTotale;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNbrFoisMed() {
		return nbrFoisMed;
	}
	public void setNbrFoisMed(int nbrFoisMed) {
		this.nbrFoisMed = nbrFoisMed;
	}
	public String getFormMed() {
		return formMed;
	}
	public void setFormMed(String formMed) {
		this.formMed = formMed;
	}
	public int getQuantMed() {
		return quantMed;
	}
	public void setQuantMed(int quantMed) {
		this.quantMed = quantMed;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
}
