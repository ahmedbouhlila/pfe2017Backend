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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity 
public class User   implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_user;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Message> messagesenvoiyer;
	
	@OneToMany(mappedBy="userrecu",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Message> messagesrecus;
	
	@JsonIgnore
	public Collection<Message> getMessagesenvoiyer() {
		return messagesenvoiyer;
	}
	@JsonSetter
	public void setMessagesenvoiyer(Collection<Message> messagesenvoiyer) {
		this.messagesenvoiyer = messagesenvoiyer;
	}
	@JsonIgnore
	public Collection<Message> getMessagesrecus() {
		return messagesrecus;
	}
	@JsonSetter
	public void setMessagesrecus(Collection<Message> messagesrecus) {
		this.messagesrecus = messagesrecus;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getCin() {
		return cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEtat_fam() {
		return etat_fam;
	}

	public void setEtat_fam(String etat_fam) {
		this.etat_fam = etat_fam;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	@JsonIgnore
	public Collection<Ordonnance_type> getOrdonnance_types() {
		return ordonnance_types;
	}
	@JsonSetter
	public void setOrdonnance_types(Collection<Ordonnance_type> ordonnance_types) {
		this.ordonnance_types = ordonnance_types;
	}
	@JsonIgnore
	public Collection<Creneaux> getCreneaux() {
		return creneaux;
	}
	@JsonSetter
	public void setCreneaux(Collection<Creneaux> creneaux) {
		this.creneaux = creneaux;
	}
	@JsonIgnore
	public Collection<Visite> getVisites() {
		return visites;
	}
	@JsonSetter
	public void setVisites(Collection<Visite> visites) {
		this.visites = visites;
	}

	private String nom;
	private String prenom;
	private Long cin;
	private int age;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date_naiss;
	private String sex;
	private Long tel;
	private String profession;
	private String email;
	private String etat_fam;
	private String login;
	private String pass;
	private String type_medecin;
	private Boolean activer;
	
	

	public Boolean getActiver() {
		return activer;
	}

	public void setActiver(Boolean activer) {
		this.activer = activer;
	}

	public String getType_medecin() {
		return type_medecin;
	}

	public void setType_medecin(String type_medecin) {
		this.type_medecin = type_medecin;
	}

	@ManyToOne
	@JoinColumn(name="CODE_role")
	private Role  role;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Ordonnance_type> ordonnance_types;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Creneaux> creneaux;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Visite> visites;
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Conger> congers;
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Notification> notifications;
	
	@JsonIgnore
	public Collection<Notification> getNotifications() {
		return notifications;
	}
	@JsonSetter
	public void setNotifications(Collection<Notification> notifications) {
		this.notifications = notifications;
	}

	@JsonIgnore
	public Collection<Conger> getCongers() {
		return congers;
	}
	@JsonSetter
	public void setCongers(Collection<Conger> congers) {
		this.congers = congers;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
