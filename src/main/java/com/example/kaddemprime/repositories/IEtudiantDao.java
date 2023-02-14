package com.example.kaddemprime.repositories;

import com.example.kaddemprime.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IEtudiantDao extends JpaRepository<Etudiant,Integer> {


    Etudiant findEtudiantByNomEAndPrenomE(String nomE , String prenomE);
    List<Etudiant> findEtudiantsByDepartement_IdDepart(Integer idD);

    List<Etudiant> findAllByDepartementIsNotNull();




}
