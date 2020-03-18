package org.Poly.Json;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JsonRendez_Vous1 {


	private int Hdebut;
	private int Hfin;
	private int Mdebut;
	private int Mfin;
	private Long id_patient;
	private String nom_patient;
	private String prenom_patient;	
	@JsonFormat(pattern="yyyy-MM-dd")
	private String jour;
	private Long   idRdv;
	private Long id_secretaire;
	public Long getId_secretaire() {
		return id_secretaire;
	}
	public void setId_secretaire(Long id_secretaire) {
		this.id_secretaire = id_secretaire;
	}
	public Long getIdRdv() {
		return idRdv;
	}
	public void setIdRdv(Long idRdv) {
		this.idRdv = idRdv;
	}
	public int getHdebut() {
		return Hdebut;
	}
	public void setHdebut(int hdebut) {
		Hdebut = hdebut;
	}
	public int getHfin() {
		return Hfin;
	}
	public void setHfin(int hfin) {
		Hfin = hfin;
	}
	public int getMdebut() {
		return Mdebut;
	}
	public void setMdebut(int mdebut) {
		Mdebut = mdebut;
	}
	public int getMfin() {
		return Mfin;
	}
	public void setMfin(int mfin) {
		Mfin = mfin;
	}
	public Long getId_patient() {
		return id_patient;
	}
	public void setId_patient(Long id_patient) {
		this.id_patient = id_patient;
	}
	public String getNom_patient() {
		return nom_patient;
	}
	public void setNom_patient(String nom_patient) {
		this.nom_patient = nom_patient;
	}
	public String getPrenom_patient() {
		return prenom_patient;
	}
	public void setPrenom_patient(String prenom_patient) {
		this.prenom_patient = prenom_patient;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	
	
	
}
