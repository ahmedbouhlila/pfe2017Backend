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
public class Notification implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_notification;

	private String type;
	
    private Long idrdv; 
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date jour;
    
	@ManyToOne
	@JoinColumn(name="CODE_user")
	private User  user;


	public Date getJour() {
		return jour;
	}


	public void setJour(Date jour) {
		this.jour = jour;
	}


	public Long getIdrdv() {
		return idrdv;
	}


	public void setIdrdv(Long idrdv) {
		this.idrdv = idrdv;
	}


	public Long getId_notification() {
		return id_notification;
	}


	public void setId_notification(Long id_notification) {
		this.id_notification = id_notification;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	
}
