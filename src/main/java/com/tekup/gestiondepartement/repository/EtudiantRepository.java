package com.tekup.gestiondepartement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gestiondepartement.model.Etudiants;

public interface EtudiantRepository extends JpaRepository<Etudiants, Integer> {

    Etudiants findByName(String name);
    
    
}