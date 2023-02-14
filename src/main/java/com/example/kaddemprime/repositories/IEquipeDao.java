package com.example.kaddemprime.repositories;

import com.example.kaddemprime.entities.Equipe;
import com.example.kaddemprime.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IEquipeDao extends JpaRepository<Equipe,Integer> {

    List<Equipe> findAllByNiveau(Niveau niveau);



}
