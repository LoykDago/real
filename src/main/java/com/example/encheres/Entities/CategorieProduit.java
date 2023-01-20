package com.example.encheres.Entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="categorieproduit")
public class CategorieProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorieproduit_idcategorieproduit_seq")
	@SequenceGenerator(name = "categorieproduit_idcategorieproduit_seq", sequenceName = "categorieproduit_idcategorieproduit_seq", allocationSize = 1)
    int idcategorieproduit   ;
    @Column
	String intitulecategorieproduit ;
    
    public CategorieProduit() {
    }
    public CategorieProduit(int idcategorieproduit, String intitulecategorieproduit) {
        this.idcategorieproduit = idcategorieproduit;
        this.intitulecategorieproduit = intitulecategorieproduit;
    }
    public int getIdcategorieproduit() {
        return idcategorieproduit;
    }
    public void setIdcategorieproduit(int idcategorieproduit) {
        this.idcategorieproduit = idcategorieproduit;
    }
    public String getIntitulecategorieproduit() {
        return intitulecategorieproduit;
    }
    public void setIntitulecategorieproduit(String intitulecategorieproduit) {
        this.intitulecategorieproduit = intitulecategorieproduit;
    }
    
}
