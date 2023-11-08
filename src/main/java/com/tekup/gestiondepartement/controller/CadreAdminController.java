package com.tekup.gestiondepartement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.gestiondepartement.model.CadreAdministratif;
import com.tekup.gestiondepartement.model.Enseignant;
import com.tekup.gestiondepartement.model.Etudiants;
import com.tekup.gestiondepartement.service.CadreAdminService;
import com.tekup.gestiondepartement.service.EnseignantService;
import com.tekup.gestiondepartement.service.EtudiantService;

@Controller
public class CadreAdminController {
    @Autowired
    private CadreAdminService service;
    @Autowired

    private EnseignantService serviceEns;
    @Autowired

    private EtudiantService serviceEtu;

    
    @GetMapping("/interfaceAdmin")
    public String home(Model model) {
        List<CadreAdministratif> CadreAdministratif = service.getCadreAdmin();
        List<Etudiants> etudiant = serviceEtu.getEtudiant();
        List<Enseignant> enseignant = serviceEns.getEnseignant();
        model.addAttribute("CadreAdministratif",CadreAdministratif );

        
        model.addAttribute("etudiant",etudiant );
         
        model.addAttribute("enseignant",enseignant );
        return "interfaceAdmin"; 
    }

      
     
      @PostMapping("/addStaff")
    public ResponseEntity<String> addStaff(@ModelAttribute CadreAdministratif staff) {
        try {
            service.addStaff(staff);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding the student.");
        }
    }
   
    //   @PostMapping("/addCadreAdministratifs")
    //   public List<CadreAdministratif> addCadreAdmins(@RequestBody List<CadreAdministratif> Cadres){
    //       return service.saveCadreAdmin(Cadres);
    //   }
    //GetAPI
    // @GetMapping("/CadreAdministratifs")
    // public List<CadreAdministratif> findAllCadres(){
    //     return service.getCadreAdmin();
    // }
 
    // @GetMapping("/CadreAdministratif/{id}")
    // public CadreAdministratif findCadreById(@PathVariable int id){
    //     return service.getCadreAdminById(id);
    // }

    // @GetMapping("/CadreAdministratif/{name}")
    // public CadreAdministratif findCadreByName(@PathVariable String name){
    //     return service.getCadreAdminByName(name);
    // }
//update 

    // @PutMapping("/updateCadre")
    // public CadreAdministratif updateCadre(@RequestBody CadreAdministratif cadre){
    //     return service.updateCadreAdmin(cadre);
    // }

    @DeleteMapping("/deleteCadre/{id}")
    public ResponseEntity<String> deleteCadre (@PathVariable int id) {
        service.deleteCadreAdmin(id);
                return ResponseEntity.ok("Staff deleted successfully");

    }
    @PutMapping("/updateStaff")
    public ResponseEntity<String> updateStaff(@RequestParam String name, @RequestParam String prenom, @RequestParam String fonction, @RequestParam String matricule) {
        try {
            service.updateTeacher(name, prenom, fonction, matricule);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating the student.");
        }
    }
}