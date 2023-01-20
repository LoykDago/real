package com.example.encheres.Entities;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="soldeutilisateurvalide")
public class SoldeUtilisateurValide {
    @Id
    @Column(name="idsoldeutilisateurvalide")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "soldeutilisateurvalide_idsoldeutilisateurvalide_seq")
	@SequenceGenerator(name = "soldeutilisateurvalide_idsoldeutilisateurvalide_seq", sequenceName = "soldeutilisateurvalide_idsoldeutilisateurvalide_seq", allocationSize = 1)
    private int idsoldeutilisateurvalide;
    @Column(name="idsoldeutilisateur")
    private int idsoldeutilisateur;
    @Column(name="datevalidation")
    private Date datevalidation = java.sql.Date.valueOf(LocalDate.now());

    public SoldeUtilisateurValide() {
    }

    public int getIdsoldeutilisateurvalide() {
        return this.idsoldeutilisateurvalide;
    }

    public void setIdsoldeutilisateurvalide(int idsoldeutilisateurvalide) {
        this.idsoldeutilisateurvalide = idsoldeutilisateurvalide;
    }

    public int getIdsoldeutilisateur() {
        return this.idsoldeutilisateur;
    }

    public void setIdsoldeutilisateur(int idsoldeutilisateur) {
        this.idsoldeutilisateur = idsoldeutilisateur;
    }

    public Date getDatevalidation() {
        return this.datevalidation;
    }

    public void setDatevalidation(Date datevalidation) {
        this.datevalidation = datevalidation;
    }

}
