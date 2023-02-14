package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.*;
import com.example.kaddemprime.repositories.IContratDao;
import com.example.kaddemprime.repositories.IDepartementDao;
import com.example.kaddemprime.repositories.IEtudiantDao;
import com.example.kaddemprime.repositories.IUniversiteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UniversiteServices implements IUniversiteServices {

    private final IUniversiteDao iUniversiteDao ;
    private final IDepartementDao iDepartementDao ;

    private final IEtudiantDao iEtudiantDao ;

    private final IContratDao iContratDao ;


    @Override
    public List<Universite> retrieveAllUniversites()
    {return iUniversiteDao.findAll();}

    @Override
    public Universite addOrUpdateUniversite(Universite u)
    {return iUniversiteDao.save(u);}

    @Override
    public Universite retrieveUniversite(Integer idUniversite)
    {return iUniversiteDao.findById(idUniversite).orElse(null);}

    @Override
    public void deleteUniversite(Integer idUniv)
    { iUniversiteDao.deleteById(idUniv); }

    @Override
    public Universite affectDepartToUniv(Integer idD, Integer idU) {
        Departement departement=  iDepartementDao.findById(idD).orElse(null);
        Universite universite = iUniversiteDao.findById(idU).orElse(null);
        List<Departement> departements = new ArrayList<>(universite.getDepartements());
        departements.add(departement);
        iUniversiteDao.save(universite);
        return universite;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {

     // List<Contrat> contrats = iContratDao.findAllByDateDebutContratGreaterThanEqualAndDateFinContratIsLessThanEqual(startDate,endDate);
     List<Contrat> contratsIA = iContratDao.findAllBySpecialiteAndDateDebutContratGreaterThanEqualAndDateFinContratIsLessThanEqual(Specialite.IA,startDate,endDate);
     List<Contrat> contratsRESEAUX = iContratDao.findAllBySpecialiteAndDateDebutContratGreaterThanEqualAndDateFinContratIsLessThanEqual(Specialite.RESEAUX,startDate,endDate);
     List<Contrat> contratsCLOUD =iContratDao.findAllBySpecialiteAndDateDebutContratGreaterThanEqualAndDateFinContratIsLessThanEqual(Specialite.CLOUD,startDate,endDate) ;
     List<Contrat> contratsSECURITY =iContratDao.findAllBySpecialiteAndDateDebutContratGreaterThanEqualAndDateFinContratIsLessThanEqual(Specialite.SECURITE,startDate,endDate);

     Integer reglementIA=0 ;
     Integer reglementRESEAUX=0 ;
     Integer reglementCLOUD=0 ;
     Integer reglementSECURITY=0 ;

     for(Contrat c :contratsIA) { reglementIA=reglementIA+c.getMontantContrat();  }
     for(Contrat c :contratsRESEAUX) { reglementRESEAUX=reglementRESEAUX+c.getMontantContrat();  }
     for(Contrat c :contratsCLOUD) { reglementCLOUD=reglementCLOUD+c.getMontantContrat();  }
     for(Contrat c :contratsSECURITY) { reglementSECURITY=reglementSECURITY+c.getMontantContrat();  }
        System.out.println(

                "Le reglement :" +"\n"+
                        "Pour les contrats dont la specialite est IA :" +reglementIA +"\n" +
                        "Pour les contrats dont la specialite est RESEAUX :" +reglementRESEAUX+"\n"+
                        "Pour les contrats dont la specialite est CLOUD : " +reglementCLOUD+"\n"+
                        "Pour les contrats dont la specialite est Securite :" +reglementSECURITY+"\n"

        );

     return reglementCLOUD+reglementIA+reglementSECURITY+reglementRESEAUX;
    }


}
