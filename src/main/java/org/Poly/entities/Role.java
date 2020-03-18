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
public class Role  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_role;
	private String type_role;
	
	@OneToMany(mappedBy="role",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<User> user;

	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}

	public String getType_role() {
		return type_role;
	}

	public void setType_role(String type_role) {
		this.type_role = type_role;
	}

	@JsonIgnore
	public Collection<User> getUser() {
		return user;
	}
	@JsonSetter
	public void setUser(Collection<User> user) {
		this.user = user;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
