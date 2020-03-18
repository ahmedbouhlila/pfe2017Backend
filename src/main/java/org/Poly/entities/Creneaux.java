package org.Poly.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity 
public class Creneaux  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_creneaux;
	
	private int Hdebut;
	private int Hfin;
	private int Mdebut;
	private int Mfin;
	private int periode;
	
	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	@OneToMany(mappedBy="creneaux",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private Collection<Rendez_vous> rendez_vous;

	@ManyToOne
	@JoinColumn(name="CODE_user")
	private User  user;

	public Creneaux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_creneaux() {
		return id_creneaux;
	}

	public void setId_creneaux(Long id_creneaux) {
		this.id_creneaux = id_creneaux;
	}

	public int getHdebut() {
		return Hdebut;
	}

	public void setHdebut(int hdebut) {
		Hdebut = hdebut;
	}

	public int getHfin() {
		return Hfin;
	}

	public void setHfin(int hfin) {
		Hfin = hfin;
	}

	public int getMdebut() {
		return Mdebut;
	}

	public void setMdebut(int mdebut) {
		Mdebut = mdebut;
	}

	public int getMfin() {
		return Mfin;
	}

	public void setMfin(int mfin) {
		Mfin = mfin;
	}

	public Collection<Rendez_vous> getRendez_vous() {
		return rendez_vous;
	}

	public void setRendez_vous(Collection<Rendez_vous> rendez_vous) {
		this.rendez_vous = rendez_vous;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
