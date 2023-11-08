package com.tekup.gestiondepartement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gestiondepartement.model.CadreAdministratif;

public interface CadreAdminRepository extends JpaRepository<CadreAdministratif, Integer> {

    CadreAdministratif findByName(String name);
    
}