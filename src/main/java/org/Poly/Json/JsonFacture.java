package org.Poly.Json;

import java.util.Date;

public class JsonFacture {

	
private Long id_facture;
	
	private String etablissement;
	private String adresse_etab;
	private Long num_tel;
	private Long num_fax;
	private Long num_fac;
	private String nom_preparateur;
	private String prenom_preparateur;
	private String date_edition;
	private Long rib_banque;
	private String etat;
	private String typeFacture;
	private float montant;
	private String typepayement;
	public String getTypepayement() {
		return typepayement;
	}
	public void setTypepayement(String typepayement) {
		this.typepayement = typepayement;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public Long getId_facture() {
		return id_facture;
	}
	public void setId_facture(Long id_facture) {
		this.id_facture = id_facture;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getAdresse_etab() {
		return adresse_etab;
	}
	public void setAdresse_etab(String adresse_etab) {
		this.adresse_etab = adresse_etab;
	}
	public Long getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(Long num_tel) {
		this.num_tel = num_tel;
	}
	public Long getNum_fax() {
		return num_fax;
	}
	public void setNum_fax(Long num_fax) {
		this.num_fax = num_fax;
	}
	public Long getNum_fac() {
		return num_fac;
	}
	public void setNum_fac(Long num_fac) {
		this.num_fac = num_fac;
	}
	public String getNom_preparateur() {
		return nom_preparateur;
	}
	public void setNom_preparateur(String nom_preparateur) {
		this.nom_preparateur = nom_preparateur;
	}
	public String getPrenom_preparateur() {
		return prenom_preparateur;
	}
	public void setPrenom_preparateur(String prenom_preparateur) {
		this.prenom_preparateur = prenom_preparateur;
	}
	public String getDate_edition() {
		return date_edition;
	}
	public void setDate_edition(String date_edition) {
		this.date_edition = date_edition;
	}
	public Long getRib_banque() {
		return rib_banque;
	}
	public void setRib_banque(Long rib_banque) {
		this.rib_banque = rib_banque;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getTypeFacture() {
		return typeFacture;
	}
	public void setTypeFacture(String typeFacture) {
		this.typeFacture = typeFacture;
	}
	
}
