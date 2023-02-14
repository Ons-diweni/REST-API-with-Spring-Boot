package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.Departement;

import java.util.List;

public interface IDepartementServices {


    List<Departement> retrieveAllDepartements();

    Departement addOrUpdateDepartement(Departement d);

    Departement retrieveDepartement (Integer idDepart);

    void deleteDepartement (Integer idD);

    Departement affectDepartToUniv(Integer idD , Integer idU);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);



}
