package org.Poly.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Prescription2 implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_prescription2;
	
	private int nbr_fois_med;
	private String form_med;
	private int quant_med;
	
	@ManyToOne
	@JoinColumn(name="CODE_ordonnance")
	private Ordonnance  ordonnance;
	
	@ManyToOne
	@JoinColumn(name="CODE_medicaments")
	private Medicaments  medicaments;

	public Prescription2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_prescription2() {
		return id_prescription2;
	}

	public void setId_prescription2(Long id_prescription2) {
		this.id_prescription2 = id_prescription2;
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

	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	public Medicaments getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(Medicaments medicaments) {
		this.medicaments = medicaments;
	}


	
}
