package com.example.encheres.Entities;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.Subselect;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Immutable
@Subselect("SELECT soldeutilisateur.idsoldeutilisateur, soldeutilisateur.valeur, soldeutilisateur.dateoperation, soldeutilisateur.idutilisateur, soldeutilisateurvalide.datevalidation FROM soldeutilisateur LEFT JOIN soldeutilisateurvalide ON soldeutilisateur.idsoldeutilisateur = soldeutilisateurvalide.idsoldeutilisateur WHERE soldeutilisateurvalide.datevalidation is null")

@Table(name = "View_allSoldes")
public class View_allSoldes implements Serializable{
    @Id
    @Column(name = "idsoldeutilisateur")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "soldeutilisateur_idsoldeutilisateur_seq")
	@SequenceGenerator(name = "soldeutilisateur_idsoldeutilisateur_seq", sequenceName = "soldeutilisateur_idsoldeutilisateur_seq", allocationSize = 1)
    private int idsoldeutilisateur;
    @Column(name = "valeur")
    private int valeur;
    @Column(name = "dateoperation")
    private Date dateoperation;
    @Column(name = "idutilisateur")
    private int idutilisateur;
    @Column(name = "datevalidation")
    private Date datevalidation;

    public View_allSoldes() {
    }

    public int getIdsoldeutilisateur() {
        return this.idsoldeutilisateur;
    }

    public void setIdsoldeutilisateur(int idsoldeutilisateur) {
        this.idsoldeutilisateur = idsoldeutilisateur;
    }

    public int getValeur() {
        return this.valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Date getDateoperation() {
        return this.dateoperation;
    }

    public void setDateoperation(Date dateoperation) {
        this.dateoperation = dateoperation;
    }

    public int getIdutilisateur() {
        return this.idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Date getDatevalidation() {
        return this.datevalidation;
    }

    public void setDatevalidation(Date datevalidation) {
        this.datevalidation = datevalidation;
    }
}
