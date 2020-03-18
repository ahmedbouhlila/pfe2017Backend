package org.Poly.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity 
public class Patient implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_patient;
	private String nom_patient;
	private String prenom_patient;
	private String sex;
	private int age;
	private String email_patient;
	private String situation_fam;
	private String profession_patient;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date_naiss;
	private Long cin;
	private String GRP_SANGIN;
	@OneToMany(mappedBy="patient",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Rendez_vous> rendez_vous;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Code_dossier")
    private Dossier_patient dossier_patient;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail_patient() {
		return email_patient;
	}

	public void setEmail_patient(String email_patient) {
		this.email_patient = email_patient;
	}

	public String getSituation_fam() {
		return situation_fam;
	}

	public void setSituation_fam(String situation_fam) {
		this.situation_fam = situation_fam;
	}

	public String getProfession_patient() {
		return profession_patient;
	}

	public void setProfession_patient(String profession_patient) {
		this.profession_patient = profession_patient;
	}

	public Date getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	public Long getCin() {
		return cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}

	public String getGRP_SANGIN() {
		return GRP_SANGIN;
	}

	public void setGRP_SANGIN(String gRP_SANGIN) {
		GRP_SANGIN = gRP_SANGIN;
	}
	@JsonIgnore
	public Collection<Rendez_vous> getRendez_vous() {
		return rendez_vous;
	}
	@JsonSetter
	public void setRendez_vous(Collection<Rendez_vous> rendez_vous) {
		this.rendez_vous = rendez_vous;
	}
//	@JsonIgnore
	public Dossier_patient getDossier_patient() {
		return dossier_patient;
	}
//	@JsonSetter
	public void setDossier_patient(Dossier_patient dossier_patient) {
		this.dossier_patient = dossier_patient;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
