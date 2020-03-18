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
public class Ordonnance implements Serializable  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_ordonnance;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date_ord;
	private String nom;	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToOne(cascade = CascadeType.ALL)
	private Visite  visite;
	
	@OneToMany(mappedBy="ordonnance",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Prescription2> prescription2;

	public Ordonnance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_ordonnance() {
		return id_ordonnance;
	}

	public void setId_ordonnance(Long id_ordonnance) {
		this.id_ordonnance = id_ordonnance;
	}

	public Date getDate_ord() {
		return date_ord;
	}

	public void setDate_ord(Date date_ord) {
		this.date_ord = date_ord;
	}
	@JsonIgnore
	public Visite getVisite() {
		return visite;
	}
	@JsonSetter
	public void setVisite(Visite visite) {
		this.visite = visite;
	}

	public Collection<Prescription2> getPrescription2() {
		return prescription2;
	}

	public void setPrescription2(Collection<Prescription2> prescription2) {
		this.prescription2 = prescription2;
	}
	
	
	
}
