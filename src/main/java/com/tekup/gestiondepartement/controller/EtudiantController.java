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
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.tekup.gestiondepartement.model.Etudiants;
import com.tekup.gestiondepartement.service.EtudiantService;


//@RestController
@Controller
public class EtudiantController {
    @Autowired
    private EtudiantService service;
    
    @GetMapping("/interfaceetudiant")
    public String home(Model model) {
        List<Etudiants> etudiant = service.getEtudiant();
        model.addAttribute("etudiant",etudiant );
        return "interfaceetudiant"; 
    }
// Add API
    // @PostMapping("/addEtudiant")
    // public Etudiants addEtudiant(@RequestBody Etudiants etudiant){
    //     return service.saveEtudiant(etudiant);
    // }
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@ModelAttribute Etudiants etudiant) {
        try {
            service.addStudent(etudiant);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding the student.");
        }
    }
 
    @PostMapping("/addEtudiants")
    public List<Etudiants> addEtudiants(@RequestBody List<Etudiants> etudiants){
        return service.saveEtudiants(etudiants);
    }
//GetAPI
    @GetMapping("/Etudiants")
    public List<Etudiants> findAllEtudiants(){
        return service.getEtudiant();
    }
 
    @GetMapping("/Etudiant/{id}")
    public Etudiants findEtudiantById(@PathVariable int id){
        return service.getEtudiantById(id);
    }

    @GetMapping("/Etudiant/{name}")
    public Etudiants findEtudiantByName(@PathVariable String name){
        return service.getEtudiantByName(name);
    }
//update 

    // @PutMapping("/updateEtudiant")
    // public Etudiants updateEtudiant(@RequestBody Etudiants etudiant){
    //     return service.updateEtudiant(etudiant);
    // }
   
    

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestParam String name, @RequestParam String prenom, @RequestParam int age, @RequestParam String matricule, @RequestParam String niveau, @RequestParam int absences) {
        try {
            service.updateStudent(name, prenom, age, matricule, niveau, absences);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating the student.");
        }
    }

    @PutMapping("/updateAbsences")
    public ResponseEntity<String> updateAbsences(@RequestParam String name, @RequestParam int absences, @RequestParam int moyenne) {
        try {
            service.updateAbsences(name, absences, moyenne);
                        return ResponseEntity.ok("success");

        } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating the student.");

        }
    }
    @DeleteMapping("/deleteEtudiant/{id}")
    public ResponseEntity<String> deleteEtudiant (@PathVariable int id) {
        service.deleteEtudiant(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
    // public void deleteEtudiant(@PathVariable int id){
    //     return service.deleteEtudiant(id);
    }

