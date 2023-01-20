package com.example.encheres.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.encheres.Entities.Admin;
import com.example.encheres.Entities.CategorieProduit;
import com.example.encheres.Entities.Enchere;
import com.example.encheres.repositories.AdminRepository;
import com.example.encheres.repositories.CategorieProduitRepository;
import com.example.encheres.repositories.EnchereRepository;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CategorieProduitRepository categorieRepository;
    @Autowired
    EnchereRepository enchereRepository;

    public AdminService() {
    }
    public List<CategorieProduit> getAllCategorieProduit(){
        return categorieRepository.findAll();
    }
    public long checkUser(Admin actuel){
        try {
            java.util.List<Admin> list=adminRepository.findAll();
            System.out.println(actuel.getPseudo()+" "+actuel.getMdp());
		    for (int i = 0; i < list.size(); i++) {
			    if (list.get(i).getPseudo().equals(actuel.getPseudo())&& list.get(i).getMdp().equals(actuel.getMdp())) {
                    return  1;
			    }
		    } 
        } catch (Exception e) {
            System.out.println(e);
        }
		 return -1;
    }
    public void deleteCategorieViaId(long id){
        categorieRepository.deleteById(id);
    }
    public void saveCategorie(CategorieProduit cp){
        categorieRepository.save(cp);
    }
    public CategorieProduit  getCategorieById(Long id)
    {
        Optional<CategorieProduit> optional = categorieRepository.findById(id);
        CategorieProduit cp = null;
        if (optional.isPresent())
            cp = optional.get();
        else
            throw new RuntimeException(
                "CategorieProduit not found for id : " + id);
        return cp;
    }
    public List<Enchere> getEnchereEnCours(){
        return enchereRepository.findByStatut("En Cours");
    }
    
}
