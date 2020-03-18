package org.Poly.Json;

public class JsonPrescription {

	
	private int nbrFoisMed ;

	private String formMed ;

	private int quantMed ;
	 private String  nom ;
	 private Long id;
	 private String ordonnance;
	public String getOrdonnance() {
		return ordonnance;
	}
	public void setOrdonnance(String ordonnance) {
		this.ordonnance = ordonnance;
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
	 
	
	
}
