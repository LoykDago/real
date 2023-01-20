package com.example.encheres.controllers;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.encheres.Entities.Admin;
import com.example.encheres.Entities.CategorieProduit;
import com.example.encheres.Entities.Enchere;
import com.example.encheres.Entities.EncheresParMois;
import com.example.encheres.Entities.SoldeUtilisateurValide;
import com.example.encheres.Entities.View_allSoldes;
import com.example.encheres.repositories.EncheresParMoisRepository;
import com.example.encheres.repositories.SoldeUtilisateurValideRepository;
import com.example.encheres.repositories.View_allSoldesRepository;
import com.example.encheres.services.AdminService;

@CrossOrigin
@Controller
@RequestMapping("/BackOffice")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    View_allSoldesRepository viewSoldesRepository;
    @Autowired
    SoldeUtilisateurValideRepository suvr;
    @Autowired
    EncheresParMoisRepository epm;

    @GetMapping("")
    public String viewLoginPage(Model model){
        Admin u=new Admin();
        model.addAttribute("user", u);
        return  "Login";
    }
    @PostMapping("/Login")
    public String Login(@ModelAttribute("user") Admin user,Model model){
        long resp=adminService.checkUser(user);
        if(resp!=-1){
            return "Accueil";
        }
        else{
            model.addAttribute("error", "Nom d'Admin ou Mot de Passe Erronee");
            return "Login";
        }
    }
    @GetMapping("/Categorie")
    public String viewCategorie(Model model){
        model.addAttribute("categorie", new CategorieProduit());
        model.addAttribute("categories", adminService.getAllCategorieProduit());
        return  "Categorie";    
    }
    @GetMapping("/Commission")
    public String viewCommission(Model model){
        model.addAttribute("com", new Enchere());
        model.addAttribute("coms", adminService.getEnchereEnCours());
        return  "Coms";    
    }
    
    
    @GetMapping("/deleteCategorie/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id,Model model) {
        adminService.deleteCategorieViaId(id);
        return viewCategorie(model); 
    }
    @PostMapping("/saveCategorie")
    public String saveEmployee(@ModelAttribute("categorie") CategorieProduit cp,Model model) {
        adminService.saveCategorie(cp);
        return viewCategorie(model); 
    }
    
    @GetMapping("/updateCategorie/{id}")
    public String updateCategorie(@PathVariable(value = "id") long id, Model model) {
        CategorieProduit cp = adminService.getCategorieById(id);
        model.addAttribute("categorie", cp);
        return "UpdateCategorie";
    }
    
    @GetMapping("/LoadAllSoldes")
    public String LoadAllSoldes(Model model){
        try {
            ArrayList<View_allSoldes> tousLesSoldes = (ArrayList<View_allSoldes>) viewSoldesRepository.findAll();
            model.addAttribute("tousLesSoldes", tousLesSoldes);
            return "AllSoldes";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "AllSoldes";
    }

    @GetMapping("/ValiderSoldes/{id}")
    public String ValiderSolde(@PathVariable(value="id") int id,Model model){
        try {
            SoldeUtilisateurValide s = new SoldeUtilisateurValide();
            s.setIdsoldeutilisateur(id);
            LocalDate today = LocalDate.now();
            s.setDatevalidation(java.sql.Date.valueOf(today));
            suvr.save(s);
            model.addAttribute("ok", "Solde valide avec succes !");        
        } catch (Exception e) {
            model.addAttribute("error", "Verifiez qu'il n'y a pas d'erreur");            
            e.printStackTrace();
        }
        return "AllSoldes";
    }

    @GetMapping("/LoadEncheresParMois")
    public String LoadEncheresParMois(Model model){
        try {
            ArrayList<EncheresParMois> tousLesEPM = (ArrayList<EncheresParMois>) epm.findAll();
            model.addAttribute("tousLesEPM", tousLesEPM);
            return "AllEPM";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "AllEPM";
    }

}
