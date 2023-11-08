package com.tekup.gestiondepartement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gestiondepartement.model.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Integer>{

    Enseignant findByName(String name);
    
}