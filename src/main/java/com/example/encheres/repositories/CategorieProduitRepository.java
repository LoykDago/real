package com.example.encheres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.encheres.Entities.Admin;
import com.example.encheres.Entities.CategorieProduit;

public interface CategorieProduitRepository extends JpaRepository<CategorieProduit,Long>{
    
}
