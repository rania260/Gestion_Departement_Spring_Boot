package com.tekup.gestiondepartement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.gestiondepartement.model.Etudiants;
import com.tekup.gestiondepartement.repository.EtudiantRepository;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository repository; 
//post methode
    // public Etudiants saveEtudiant (Etudiants etudiants){

    //    return repository.save(etudiants);
    // }
    public void addStudent(Etudiants etudiants) {
        repository.save(etudiants);
    }

     public List<Etudiants> saveEtudiants (List<Etudiants> etudiantss){

       return repository.saveAll(etudiantss);
    }
//get methode
    public List<Etudiants> getEtudiant(){
        return repository.findAll();
    }

    public Etudiants getEtudiantById(int id){
        return repository.findById(id).orElse(null);
    }

    public Etudiants getEtudiantByName(String name){
        return repository.findByName(name);
    }

//delete methode
    public void deleteEtudiant(int id){
        repository.deleteById(id);
        
    }
//update methode
    public Etudiants updateEtudiant(Etudiants etudiant){
        Etudiants existingEtudiant = repository.findById(etudiant.getId()).orElse(null);
        existingEtudiant.setName(etudiant.getName());
        existingEtudiant.setPrenom(etudiant.getPrenom());
        existingEtudiant.setAge(etudiant.getAge());
        existingEtudiant.setMatricule(etudiant.getMatricule());
        existingEtudiant.setNiveau(etudiant.getNiveau());
        existingEtudiant.setAbsences(etudiant.getAbsences());
        existingEtudiant.setMoyenne(etudiant.getMoyenne());
        return repository.save(existingEtudiant);

        
    }
     public void updateMoyenne(String name,int moyenne) {
                Etudiants etudiant = repository.findByName(name);
        if (etudiant != null) {
                    etudiant.setName(name);

            etudiant.setMoyenne(moyenne);
            repository.save(etudiant);
        } else {
            throw new StudentNotFoundException("Student not found");
        }
    }
    public void updateAbsences(String name,int absences, int moyenne) {
                Etudiants etudiant = repository.findByName(name);
        if (etudiant != null) {
                    etudiant.setName(name);

            etudiant.setAbsences(absences);
                        etudiant.setMoyenne(moyenne);

            repository.save(etudiant);
        } else {
            throw new StudentNotFoundException("Student not found");
        }
    }
    public void updateStudent(String name, String prenom, int age, String matricule, String niveau, int absences) {
        // Retrieve the student from the database by some unique identifier, e.g., ID or a combination of fields.
        Etudiants etudiant = repository.findByName(name);

        if (etudiant != null) {
            // Update the student data
        etudiant.setName(name);
        etudiant.setPrenom(prenom);
        etudiant.setMatricule(matricule);
        etudiant.setNiveau(niveau);
        etudiant.setAge(age);
        etudiant.setAbsences(absences);
            

            // Save the updated student back to the database
            repository.save(etudiant);
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