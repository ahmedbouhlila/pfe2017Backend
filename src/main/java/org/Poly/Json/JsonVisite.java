package org.Poly.Json;

import java.util.Date;

public class JsonVisite {
	private Long   idRdv;
	private Date date_debut;
	private Date date_fin;
    private String rapport;	
	private Long idUser;
	private Long idPatient;
	
	private int nbrFoisMed ;

	private String formMed ;

	private int quantMed ;
	 private String  nom ;
	public Long getIdRdv() {
		return idRdv;
	}
	public void setIdRdv(Long idRdv) {
		this.idRdv = idRdv;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public String getRapport() {
		return rapport;
	}
	public void setRapport(String rapport) {
		this.rapport = rapport;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
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
