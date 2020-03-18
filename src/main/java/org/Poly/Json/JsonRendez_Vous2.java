package org.Poly.Json;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JsonRendez_Vous2 {

	private int Hdebut;
	private int Hfin;
	private int Mdebut;
	private int Mfin;
	private String nomPatient;
	private String prenomPatient;	
	@JsonFormat(pattern="yyyy-MM-dd")
	private String jour;
	private String nomMedecin;
	private String prenomMedecin;
	private String typeMedecin;
	private Long   idRdv;
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
	public String getNomPatient() {
		return nomPatient;
	}
	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}
	public String getPrenomPatient() {
		return prenomPatient;
	}
	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
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
	public Long getIdRdv() {
		return idRdv;
	}
	public void setIdRdv(Long idRdv) {
		this.idRdv = idRdv;
	}


}
