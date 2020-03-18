package org.Poly.Json;

public class JsonOrdonnance {

	private int nbrFoisMed ;

	private String formMed ;

	private int quantMed ;
	 private String  nom ;
	 private String etat;
	 private Long id;
	 private float prixUnitaire;
	 private float prixTotale; 	
	private Boolean check;
	private int quantprise;
	private int quantmax;
	public int getQuantmax() {
		return quantmax;
	}
	public void setQuantmax(int quantmax) {
		this.quantmax = quantmax;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Boolean getCheck() {
		return check;
	}
	public void setCheck(Boolean check) {
		this.check = check;
	}
	public int getQuantprise() {
		return quantprise;
	}
	public void setQuantprise(int quantprise) {
		this.quantprise = quantprise;
	}
	 
	
	
	
}
