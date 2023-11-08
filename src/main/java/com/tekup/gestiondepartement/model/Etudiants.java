package com.tekup.gestiondepartement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Etudiants")
public class Etudiants {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String prenom;
    private int age;
    private String matricule;
    private String niveau;
    private int absences;
        private int moyenne;


}