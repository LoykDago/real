package com.example.encheres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.encheres.Entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long>{
    
}
