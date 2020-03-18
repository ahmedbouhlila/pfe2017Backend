package org.Poly.Json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JsonDossierPatient {

	
	
	private String nomMedecin;
	private String prenomMedecin;
	private String typeMedecin;
	private int age;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date_fin ; 
	private Long id_visite;
	 private String  rapport ;
	 private String etat;
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getRapport() {
		return rapport;
	}
	public void setRapport(String rapport) {
		this.rapport = rapport;
	}
	public String getNomMedecin() {
		return nomMedecin;
	}
	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}
	public String getPrenomMedecin() {
		return prenomMedecin;
	}
	public void setPrenomMedecin(String prenomMedecin) {
		this.prenomMedecin = prenomMedecin;
	}
	public String getTypeMedecin() {
		return typeMedecin;
	}
	public void setTypeMedecin(String typeMedecin) {
		this.typeMedecin = typeMedecin;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public Long getId_visite() {
		return id_visite;
	}
	public void setId_visite(Long id_visite) {
		this.id_visite = id_visite;
	}
	
}
