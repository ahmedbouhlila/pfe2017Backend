package org.Poly.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class Rendez_vous  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_rendez_vous;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date jour;
	
	@ManyToOne
	@JoinColumn(name="CODE_patient")
	private Patient  patient;
	
	@ManyToOne
	@JoinColumn(name="CODE_creneaux")
	private Creneaux  creneaux;
 private Long id_secretaire;


	public Long getId_secretaire() {
	return id_secretaire;
}

public void setId_secretaire(Long id_secretaire) {
	this.id_secretaire = id_secretaire;
}

	public Rendez_vous() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_rendez_vous() {
		return id_rendez_vous;
	}

	public void setId_rendez_vous(Long id_rendez_vous) {
		this.id_rendez_vous = id_rendez_vous;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@JsonIgnore
	public Creneaux getCreneaux() {
		return creneaux;
	}
	@JsonSetter
	public void setCreneaux(Creneaux creneaux) {
		this.creneaux = creneaux;
	}
	
	
	
}
