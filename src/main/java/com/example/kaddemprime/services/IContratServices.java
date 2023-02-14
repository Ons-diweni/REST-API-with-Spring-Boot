package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratServices {

    List <Contrat> retrieveAllContrats();

    Contrat addOrUpdateContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);

    Contrat affectContratToEtudiant (Contrat ce,String nomE,String prenomE);

    Integer nbContratsValides(Date startDate, Date endDate);

    String retrieveAndUpdateStatusContrat();

    void retrieveAllExpireIn15Days();


}
