package org.Poly.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity 
public class Dossier_patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_dossier_patient;
	private Long num_dossier;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Code_patient")
    private Patient patient;
	
	@OneToMany(mappedBy="dossier_patient",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Visite> visites;

	public Dossier_patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_dossier_patient() {
		return id_dossier_patient;
	}

	public void setId_dossier_patient(Long id_dossier_patient) {
		this.id_dossier_patient = id_dossier_patient;
	}

	public Long getNum_dossier() {
		return num_dossier;
	}

	public void setNum_dossier(Long num_dossier) {
		this.num_dossier = num_dossier;
	}

	@JsonIgnore
	public Patient getPatient() {
		return patient;
	}
	@JsonSetter
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@JsonIgnore
	public Collection<Visite> getVisites() {
		return visites;
	}
	@JsonSetter
	public void setVisites(Collection<Visite> visites) {
		this.visites = visites;
	}
	
	
}
