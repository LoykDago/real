package com.example.encheres.Entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "enchere")
public class Enchere {
	@Id
    @Column(name = "idenchere")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "enchere_idenchere_seq")
	@SequenceGenerator(name="enchere_idenchere_seq", sequenceName="enchere_idenchere_seq",allocationSize = 1)
    private int idenchere;
    @Column(name = "dateenchere")
    private Timestamp dateEnchere;
    @Column(name = "gagnant")
    private Long gagnant;
	@Column(name = "idenchereur")
    private Long idenchereur;
    @Column(name = "sommedepart")
    private Long sommeDepart;
    @Column(name = "datefin")
    private Timestamp dateFin;
    @Column(name = "commission")
    private Double commission;
    
    @Column(name = "prixminimumdevente")
    private Long prixMinimumDeVente;
    
    @Column(name = "designationproduit")
    private String designationProduit;
    
    @Column(name = "idcategorie")
    private Long categorie;
    
    @Column(name = "statut")
    private String statut;

	

	

	public int getIdEnchere() {
		return idenchere;
	}

	public void setIdEnchere(int idenchere) {
		this.idenchere = idenchere;
	}

	public Timestamp getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Timestamp dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Long getGagnant() {
		return gagnant;
	}

	public void setGagnant(Long gagnant) {
		this.gagnant = gagnant;
	}

	

	public Long getIdenchereur() {
		return idenchereur;
	}

	public void setIdenchereur(Long idenchereur) {
		this.idenchereur = idenchereur;
	}

	public Long getSommeDepart() {
		return sommeDepart;
	}

	public void setSommeDepart(Long sommeDepart) {
		this.sommeDepart = sommeDepart;
	}

	public Timestamp getDateFin() {
		return dateFin;
	}

	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Long getPrixMinimumDeVente() {
		return prixMinimumDeVente;
	}

	public void setPrixMinimumDeVente(Long prixMinimumDeVente) {
		this.prixMinimumDeVente = prixMinimumDeVente;
	}

	public String getDesignationProduit() {
		return designationProduit;
	}

	public void setDesignationProduit(String designationProduit) {
		this.designationProduit = designationProduit;
	}

	public Long getCategorie() {
		return categorie;
	}

	public void setCategorie(Long categorie) {
		this.categorie = categorie;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getIdenchere() {
		return idenchere;
	}

	public void setIdenchere(int idenchere) {
		this.idenchere = idenchere;
	}

  
    
    
}