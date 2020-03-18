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
public class Prescription1 implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_prescription1;
	
	private int nbr_fois_med;
	private String form_med;
	private int quant_med;
	
	@ManyToOne
	@JoinColumn(name="CODE_ordonnance_type")
	private Ordonnance_type  ordonnance_type;
	
	@ManyToOne
	@JoinColumn(name="CODE_medicaments")
	private Medicaments  medicaments;

	public Prescription1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_prescription1() {
		return id_prescription1;
	}

	public void setId_prescription1(Long id_prescription1) {
		this.id_prescription1 = id_prescription1;
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
	public Ordonnance_type getOrdonnance_type() {
		return ordonnance_type;
	}
	@JsonSetter
	public void setOrdonnance_type(Ordonnance_type ordonnance_type) {
		this.ordonnance_type = ordonnance_type;
	}

	public Medicaments getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(Medicaments medicaments) {
		this.medicaments = medicaments;
	}

	
	
}
