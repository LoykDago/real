package com.example.encheres.Entities;

import java.io.Serializable;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Subselect("SELECT EXTRACT(MONTH FROM dateenchere) as mois, COUNT(*) as nbrEncheres FROM enchere group by EXTRACT(MONTH FROM dateenchere)")

@Table(name = "encheresParMois")
public class EncheresParMois implements Serializable {
    @Id
    @Column(name="mois")
    private int mois;
    @Column(name="nbrencheres")
    private int nbrencheres;

    public EncheresParMois() {
    }

    public int getMois() {
        return this.mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getNbrencheres() {
        return this.nbrencheres;
    }

    public void setNbrencheres(int nbrencheres) {
        this.nbrencheres = nbrencheres;
    }
}
