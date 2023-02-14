package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.Contrat;
import com.example.kaddemprime.entities.Departement;
import com.example.kaddemprime.entities.Equipe;
import com.example.kaddemprime.entities.Etudiant;
import com.example.kaddemprime.repositories.IContratDao;
import com.example.kaddemprime.repositories.IDepartementDao;
import com.example.kaddemprime.repositories.IEquipeDao;
import com.example.kaddemprime.repositories.IEtudiantDao;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
@RequiredArgsConstructor
public class EtudiantServices implements IEtudiantServices{


   private final   IEtudiantDao iEtudiantDao;
   private final IEquipeDao iEquipeDao ;
   private final IContratDao iContratDao;

   private final IDepartementDao iDepartementDao;


    @Override
    public List<Etudiant> retrieveAllEtudiants()
    {return iEtudiantDao.findAll();}

    @Override
    public Etudiant addOrUpdateEtudiant(Etudiant e)
    {return iEtudiantDao.save(e); }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant)
    { return iEtudiantDao.findById(idEtudiant).orElse(null);}

    @Override
    public void removeEtudiant(Integer idEtudiant)
    { iEtudiantDao.deleteById(idEtudiant);}

    @Override
    public Etudiant addEtudiantAddContratAvecAffec(Etudiant etudiant, Contrat contrat) {
        iEtudiantDao.save(etudiant);
        contrat.setEtudiant(etudiant);
        iContratDao.save(contrat);
        return etudiant;
    }



    @Override
   public Etudiant addEtudiantAddEquipeAvecAffec(Etudiant etudiant, Equipe equipe) {

     iEtudiantDao.save(etudiant);
     iEquipeDao.save(equipe);
     if(etudiant.getEquipes()== null) { Set<Equipe> equipes1 = new HashSet<>(); equipes1.add(equipe); etudiant.setEquipes(equipes1);}
     else {etudiant.getEquipes().add(equipe); }
     iEtudiantDao.save(etudiant);
     return etudiant;
   }

    @Override
    public Etudiant addEtudiantAndAffectToContrat(Etudiant etudiant, Integer idC) {

       iEtudiantDao.save(etudiant);
       Contrat contrat = iContratDao.findById(idC).orElse(null);
       contrat.setEtudiant(etudiant);
       iContratDao.save(contrat);
       iEtudiantDao.save(etudiant);
        return etudiant;
    }

    @Override
    public void AffectEtudiantToDepart(Integer idE, Integer idD) {

        Etudiant etudiant = iEtudiantDao.findById(idE).orElse(null);
        Departement departement = iDepartementDao.findById(idD).orElse(null);
        etudiant.setDepartement(departement);
        iEtudiantDao.save(etudiant);

    }

    @Override
    public Etudiant AffectEtudiantToContrat(Integer idE, Integer idC) {

     Etudiant etudiant= iEtudiantDao.findById(idE).orElse(null);
     Contrat contrat = iContratDao.findById(idC).orElse(null);
     contrat.setEtudiant(etudiant);
     iContratDao.save(contrat);
     return etudiant;
    }

    @Override
    public Etudiant affectEtudiantToEquipe(Integer idEtudiant, Integer idEquipe) {

     Etudiant etudiant = iEtudiantDao.findById(idEtudiant).orElse(null);
     Equipe equipe = iEquipeDao.findById(idEquipe).orElse(null);

     if(etudiant.getEquipes()==null)  { Set<Equipe> equipes = new HashSet<>(); equipes.add(equipe); etudiant.setEquipes(equipes); }
     else etudiant.getEquipes().add(equipe);
     iEtudiantDao.save(etudiant);
     return etudiant;
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {

        iEtudiantDao.save(e);
        Equipe equipe = iEquipeDao.findById(idEquipe).orElse(null);

        if(e.getEquipes()==null) { Set<Equipe> equipes = new HashSet<>(); equipes.add(equipe); e.setEquipes(equipes);}
        else e.getEquipes().add(equipe);

        iEtudiantDao.save(e);
        Contrat contrat =   iContratDao.findById(idContrat).orElse(null);
        contrat.setEtudiant(e);
        iContratDao.save(contrat);
        return e;
    }


    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return iEtudiantDao.findEtudiantsByDepartement_IdDepart(idDepartement);
    }


}
