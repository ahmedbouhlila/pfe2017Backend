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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity 
public class Visite implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_visite;
	
	private Date date_debut;
	private Date date_fin;
private String rapport;	
	public String getRapport() {
	return rapport;
}


public void setRapport(String rapport) {
	this.rapport = rapport;
}


	@OneToMany(mappedBy="visite",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Facture> factures;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ordonnance ordonnances;
	
	@ManyToOne
	@JoinColumn(name="CODE_user")
	private User  user;
	
	
	@ManyToOne
	@JoinColumn(name="CODE_dossier_patient")
	private Dossier_patient  dossier_patient;


	public Visite() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId_visite() {
		return id_visite;
	}


	public void setId_visite(Long id_visite) {
		this.id_visite = id_visite;
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


	
	
	
	
	public Collection<Facture> getFactures() {
		return factures;
	}

	
	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}


	public Ordonnance getOrdonnances() {
		return ordonnances;
	}


	public void setOrdonnances(Ordonnance ordonnances) {
		this.ordonnances = ordonnances;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Dossier_patient getDossier_patient() {
		return dossier_patient;
	}


	public void setDossier_patient(Dossier_patient dossier_patient) {
		this.dossier_patient = dossier_patient;
	}
	
	
	
}
