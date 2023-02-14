package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.Departement;
import com.example.kaddemprime.entities.Universite;
import com.example.kaddemprime.repositories.IDepartementDao;
import com.example.kaddemprime.repositories.IUniversiteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartementServices implements IDepartementServices{

   private  final IDepartementDao iDepartementDao;
   private  final IUniversiteDao iUniversiteDao ;


    @Override
    public List<Departement> retrieveAllDepartements()
    { return iDepartementDao.findAll();}

    @Override
    public Departement addOrUpdateDepartement(Departement d)
    {return iDepartementDao.save(d); }

    @Override
    public Departement retrieveDepartement(Integer idDepart)
    {return iDepartementDao.findById(idDepart).orElse(null);}

    @Override
    public void deleteDepartement(Integer idD)
    { iDepartementDao.deleteById(idD);}

    @Override
    public Departement affectDepartToUniv(Integer idD, Integer idU)
    {   Departement departement=  iDepartementDao.findById(idD).orElse(null);
        Universite universite = iUniversiteDao.findById(idU).orElse(null);
        List<Departement> departements = new ArrayList<>(universite.getDepartements());
        departements.add(departement);
        iUniversiteDao.save(universite);
        return departement;
     }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = iUniversiteDao.findById(idUniversite).orElse(null);
        List<Departement> departements = new ArrayList<>(universite.getDepartements());
        return departements;
    }


}
