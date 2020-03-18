package org.Poly.Json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JsonRendez_Vous {

	private int Hdebut;
	private int Hfin;
	private int Mdebut;
	private int Mfin;
	private Long id_rendez_vous;
	private String nom;
	private String prenom;
	private String type_medecin;
	@JsonFormat(pattern="yyyy-MM-dd")
	private String jour;
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
	public Long getId_rendez_vous() {
		return id_rendez_vous;
	}
	public void setId_rendez_vous(Long id_rendez_vous) {
		this.id_rendez_vous = id_rendez_vous;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getType_medecin() {
		return type_medecin;
	}
	public void setType_medecin(String type_medecin) {
		this.type_medecin = type_medecin;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	
	
	
	
	
	
}
