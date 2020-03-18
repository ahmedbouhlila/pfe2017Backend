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

@Entity
public class Conger implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConger;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateDebut;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateFin;

	@ManyToOne
	@JoinColumn(name = "CODE_user")
	private User user;

	public Long getIdConger() {
		return idConger;
	}

	public void setIdConger(Long idConger) {
		this.idConger = idConger;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
