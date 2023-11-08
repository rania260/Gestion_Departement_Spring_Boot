package com.tekup.gestiondepartement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.gestiondepartement.model.CadreAdministratif;
import com.tekup.gestiondepartement.model.Enseignant;
import com.tekup.gestiondepartement.repository.CadreAdminRepository;

@Service
public class CadreAdminService {
    @Autowired
    private CadreAdminRepository repository;
    public void addStaff (CadreAdministratif staff) {
    repository.save(staff);
  }
    //post methode
    public CadreAdministratif saveCadreAdministratif (CadreAdministratif cadreAdmin){

        return repository.save(cadreAdmin);
     }
 
      public List<CadreAdministratif> saveCadreAdmin (List<CadreAdministratif> cadreAdmins){
 
        return repository.saveAll(cadreAdmins);
     }
 
     //get methode
     public List<CadreAdministratif> getCadreAdmin(){
       return repository.findAll();
   }
 
   public CadreAdministratif getCadreAdminById(int id){
       return repository.findById(id).orElse(null);
   }
 
   public CadreAdministratif getCadreAdminByName(String name){
       return repository.findByName(name);
   }
 
 //delete methode
   public String deleteCadreAdmin(int id){
       repository.deleteById(id);
       return "Staff supprimer!! " +id;
   }

  
 //update methode
  //  public CadreAdministratif updateCadreAdmin(CadreAdministratif cadreAdmin){
  //      CadreAdministratif existingCadre = repository.findById(cadreAdmin.getId()).orElse(null);
  //      existingCadre.setName(cadreAdmin.getName());
  //      existingCadre.setPrenom(cadreAdmin.getPrenom());
  //      existingCadre.setFonction(cadreAdmin.getFonction());
  //      existingCadre.setMatricule(cadreAdmin.getMatricule());
  //      return repository.save(existingCadre);
 
       
  //  }
   public void updateTeacher(String name, String prenom, String fonction, String matricule) {
    // Retrieve the student from the database by some unique identifier, e.g., ID or a combination of fields.
    CadreAdministratif CadreAdministratif = repository.findByName(name);

    if (CadreAdministratif != null) {
        // Update the student data
    CadreAdministratif.setName(name);
    CadreAdministratif.setPrenom(prenom);
    CadreAdministratif.setFonction(fonction);
    CadreAdministratif.setMatricule(matricule);
 
        

        // Save the updated student back to the database
        repository.save(CadreAdministratif);
    } else {
        
        // Handle the case where the student is not found
        throw new StudentNotFoundException("Student not found");
    }
}
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
}