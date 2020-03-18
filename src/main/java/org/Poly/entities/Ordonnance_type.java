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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
public class Ordonnance_type implements Serializable  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_ordonnance_type;
	@JsonFormat(pattern="yyyy-MM-dd")
private Date date_ord;
private String nom;	
	public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

	@ManyToOne
	@JoinColumn(name="CODE_user")
	private User  user;
	
	@OneToMany(mappedBy="ordonnance_type",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Prescription1> prescription1;

	public Ordonnance_type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_ordonnance_type() {
		return id_ordonnance_type;
	}

	public void setId_ordonnance_type(Long id_ordonnance_type) {
		this.id_ordonnance_type = id_ordonnance_type;
	}

	public Date getDate_ord() {
		return date_ord;
	}

	public void setDate_ord(Date date_ord) {
		this.date_ord = date_ord;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Prescription1> getPrescription1() {
		return prescription1;
	}

	public void setPrescription1(Collection<Prescription1> prescription1) {
		this.prescription1 = prescription1;
	}
	
	
	
}
