package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.Departement;
import com.example.kaddemprime.entities.Universite;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface IUniversiteServices {

    List <Universite> retrieveAllUniversites();

    Universite addOrUpdateUniversite (Universite u);

    Universite retrieveUniversite (Integer idUniversite);

    void deleteUniversite (Integer idUniv);

    Universite affectDepartToUniv (Integer idD , Integer idU);

    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
}
