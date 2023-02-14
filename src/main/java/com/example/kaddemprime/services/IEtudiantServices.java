package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.Contrat;
import com.example.kaddemprime.entities.Equipe;
import com.example.kaddemprime.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {

    List<Etudiant> retrieveAllEtudiants();

    Etudiant addOrUpdateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);

    Etudiant addEtudiantAddContratAvecAffec(Etudiant etudiant, Contrat contrat) ;

    public Etudiant addEtudiantAddEquipeAvecAffec (Etudiant etudiant , Equipe equipe);

    public Etudiant addEtudiantAndAffectToContrat (Etudiant etudiant,Integer idC) ;

    public void  AffectEtudiantToDepart (Integer idE,Integer idD);

    public Etudiant  AffectEtudiantToContrat (Integer idE,Integer idC);

    public Etudiant affectEtudiantToEquipe(Integer idEtudiant,Integer idEquipe);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer
            idEquipe);

    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);

}
