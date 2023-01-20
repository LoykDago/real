package com.example.encheres.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.encheres.Entities.Admin;
import com.example.encheres.Entities.Enchere;

public interface EnchereRepository extends JpaRepository<Enchere,Long>{
    List<Enchere> findByStatut(String name);
}

