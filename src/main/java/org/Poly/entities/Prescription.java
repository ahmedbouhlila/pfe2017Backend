package org.Poly.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity 
public class Prescription implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_prescription;
	
	private int nbr_fois_med;
	private String form_med;
	private int quant_med;
	
	@ManyToOne
	@JoinColumn(name="CODE_ordonnance_globale")
	private Ordonnance_globale  ordonnance_globale;
	
	@ManyToOne
	@JoinColumn(name="CODE_medicaments")
	private Medicaments  medicaments;

	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_prescription() {
		return id_prescription;
	}

	public void setId_prescription(Long id_prescription) {
		this.id_prescription = id_prescription;
	}

	public int getNbr_fois_med() {
		return nbr_fois_med;
	}

	public void setNbr_fois_med(int nbr_fois_med) {
		this.nbr_fois_med = nbr_fois_med;
	}

	public String getForm_med() {
		return form_med;
	}

	public void setForm_med(String form_med) {
		this.form_med = form_med;
	}

	public int getQuant_med() {
		return quant_med;
	}

	public void setQuant_med(int quant_med) {
		this.quant_med = quant_med;
	}

	@JsonIgnore
	public Ordonnance_globale getOrdonnance_globale() {
		return ordonnance_globale;
	}
	@JsonSetter
	public void setOrdonnance_globale(Ordonnance_globale ordonnance_globale) {
		this.ordonnance_globale = ordonnance_globale;
	}

	public Medicaments getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(Medicaments medicaments) {
		this.medicaments = medicaments;
	}

	
	
}
