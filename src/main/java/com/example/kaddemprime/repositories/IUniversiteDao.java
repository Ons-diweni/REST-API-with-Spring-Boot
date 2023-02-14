package com.example.kaddemprime.repositories;


import com.example.kaddemprime.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IUniversiteDao extends JpaRepository<Universite,Integer> {



}
