package org.Poly.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity 
public class Medicaments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_medicaments;
	private int nbr;
	private String nom;
	private float prix;
	
	@OneToMany(mappedBy="medicaments",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Prescription2> prescription2;
	
	@OneToMany(mappedBy="medicaments",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Prescription1> prescription1;

	@OneToMany(mappedBy="medicaments",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Prescription> prescriptions;

	public Medicaments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_medicaments() {
		return id_medicaments;
	}

	public void setId_medicaments(Long id_medicaments) {
		this.id_medicaments = id_medicaments;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	@JsonIgnore
	public Collection<Prescription2> getPrescription2() {
		return prescription2;
	}
	@JsonSetter
	public void setPrescription2(Collection<Prescription2> prescription2) {
		this.prescription2 = prescription2;
	}
	@JsonIgnore
	public Collection<Prescription1> getPrescription1() {
		return prescription1;
	}
	@JsonSetter
	public void setPrescription1(Collection<Prescription1> prescription1) {
		this.prescription1 = prescription1;
	}
	@JsonIgnore
	public Collection<Prescription> getPrescriptions() {
		return prescriptions;
	}
	@JsonSetter
	public void setPrescriptions(Collection<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}



}
