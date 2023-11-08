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

import com.tekup.gestiondepartement.model.Enseignant;
import com.tekup.gestiondepartement.model.Etudiants;
import com.tekup.gestiondepartement.service.EnseignantService;
import com.tekup.gestiondepartement.service.EtudiantService;

@Controller
public class EnseignantController {
    @Autowired
    private EnseignantService service;

    @Autowired

    private EtudiantService serviceEtu;

    @GetMapping("/interfaceEnseignant")
    public String home(Model model) {
        List<Enseignant> enseignant = service.getEnseignant();
        List<Etudiants> etudiant = serviceEtu.getEtudiant();

        model.addAttribute("enseignant",enseignant );
        model.addAttribute("etudiant",etudiant );

        return "interfaceEnseignant";
    }

   
    
    @PostMapping("/addTeacher")
    public ResponseEntity<String> addTeacher(@ModelAttribute Enseignant enseignant) {
        try {
            service.saveEnseignant(enseignant);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding the student.");
        }
    }
    @PostMapping("/addEnseignants")
    public List<Enseignant> addEnseignants(@RequestBody List<Enseignant> enseignants){
        return service.saveEnseignant(enseignants);
    }

    //GetAPI
    @GetMapping("/Enseignants")
    public List<Enseignant> findAllEnseignants(){
        return service.getEnseignant();
    }
 
    @GetMapping("/Enseignant/{id}")
    public Enseignant findEtudiantById(@PathVariable int id){
        return service.getEnseignantById(id);
    }

    @GetMapping("/Enseignant/{name}")
    public Enseignant findEnseignantByName(@PathVariable String name){
        return service.getEnseignantByName(name);
    }
//update 

    // @PutMapping("/updateEnseignant")
    // public Enseignant updateEnseignant(@RequestBody Enseignant enseignant){
    //     return service.updateEnseignant(enseignant);
    // }
    @PutMapping("/updateTeacher")
    public ResponseEntity<String> updateTeacher(@RequestParam String name, @RequestParam String prenom, @RequestParam String specialite, @RequestParam String matricule) {
        try {
            service.updateTeacher(name, prenom, specialite, matricule);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating the student.");
        }
    }
    @DeleteMapping("/deleteEnseignant/{id}")
    public ResponseEntity<String> deleteTeacher (@PathVariable int id) {
        service.deleteEnseignant(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
    // public String deleteEnseignant(@PathVariable int id){
    //     return service.deleteEnseignant(id);
    // }
}