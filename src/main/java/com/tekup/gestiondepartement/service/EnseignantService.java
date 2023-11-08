package com.tekup.gestiondepartement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.gestiondepartement.model.Enseignant;
import com.tekup.gestiondepartement.model.Etudiants;
import com.tekup.gestiondepartement.repository.EnseignantRepository;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository repository;
  public void addTeacher (Enseignant enseignant) {
    repository.save(enseignant);
  }
    //post methode
    public Enseignant saveEnseignant (Enseignant enseignant){

       return repository.save(enseignant);
    }

     public List<Enseignant> saveEnseignant (List<Enseignant> enseignants){

       return repository.saveAll(enseignants);
    }

    //get methode
    public List<Enseignant> getEnseignant(){
      return repository.findAll();
  }

  public Enseignant getEnseignantById(int id){
      return repository.findById(id).orElse(null);
  }

  public Enseignant getEnseignantByName(String name){
      return repository.findByName(name);
  }

//delete methode
  public String deleteEnseignant(int id){
      repository.deleteById(id);
      return "Enseignant supprimer!! " +id;
  }
//update methode
//   public Enseignant updateEnseignant(Enseignant enseignant){
//       Enseignant existingEnseignant = repository.findById(enseignant.getId()).orElse(null);
//       existingEnseignant.setName(enseignant.getName());
//       existingEnseignant.setPrenom(enseignant.getPrenom());
//       existingEnseignant.setSpecialite(enseignant.getSpecialite());
//       existingEnseignant.setMatricule(enseignant.getMatricule());
//       return repository.save(existingEnseignant);

      
//   }
 public void updateTeacher(String name, String prenom, String specialite, String matricule) {
        // Retrieve the student from the database by some unique identifier, e.g., ID or a combination of fields.
        Enseignant enseignant = repository.findByName(name);

        if (enseignant != null) {
            // Update the student data
        enseignant.setName(name);
        enseignant.setPrenom(prenom);
        enseignant.setSpecialite(specialite);
        enseignant.setMatricule(matricule);
     
            

            // Save the updated student back to the database
            repository.save(enseignant);
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