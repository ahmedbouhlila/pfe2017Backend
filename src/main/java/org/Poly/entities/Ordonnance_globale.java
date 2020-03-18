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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
public class Ordonnance_globale implements Serializable  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_ordonnance_globale;
	private String nom;	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date_ord;
	
	@OneToMany(mappedBy="ordonnance_globale",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Prescription> prescription;

	public Ordonnance_globale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_ordonnance_globale() {
		return id_ordonnance_globale;
	}

	public void setId_ordonnance_globale(Long id_ordonnance_globale) {
		this.id_ordonnance_globale = id_ordonnance_globale;
	}

	public Date getDate_ord() {
		return date_ord;
	}

	public void setDate_ord(Date date_ord) {
		this.date_ord = date_ord;
	}

	public Collection<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(Collection<Prescription> prescription) {
		this.prescription = prescription;
	}
	
	
	
}
