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
public class Message implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmessage;
	
	
	private String message;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name="user_envoie")
	private User  user;
	
	
	@ManyToOne
	@JoinColumn(name="user_recu")
	private User  userrecu;


	public Long getIdmessage() {
		return idmessage;
	}


	public void setIdmessage(Long idmessage) {
		this.idmessage = idmessage;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public User getUserrecu() {
		return userrecu;
	}


	public void setUserrecu(User userrecu) {
		this.userrecu = userrecu;
	}
	
	
	
	
	
}
