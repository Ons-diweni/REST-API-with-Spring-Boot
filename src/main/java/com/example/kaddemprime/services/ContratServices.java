package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.Contrat;
import com.example.kaddemprime.entities.Etudiant;
import com.example.kaddemprime.repositories.IContratDao;
import com.example.kaddemprime.repositories.IEtudiantDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ContratServices implements IContratServices{

    private final IContratDao iContratDao ;
    private final IEtudiantDao iEtudiantDao ;

    @Override
    public List<Contrat> retrieveAllContrats()
    {return iContratDao.findAll(); }

    @Override
    public Contrat addOrUpdateContrat(Contrat ce)
    {return iContratDao.save(ce); }

    @Override
    public Contrat retrieveContrat(Integer idContrat)
    {return iContratDao.findById(idContrat).orElse(null);}

    @Override
    public void removeContrat(Integer idContrat)
    {  iContratDao.deleteById(idContrat);}



    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {

        Etudiant etudiant= iEtudiantDao.findEtudiantByNomEAndPrenomE(nomE,prenomE);
        if (etudiant.getContrats().size()<5) {ce.setEtudiant(etudiant); iContratDao.save(ce);}
        return ce;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = iContratDao.findContratsByArchiveIsFalseAndDateDebutContratGreaterThanEqualAndDateFinContratIsLessThanEqual(startDate,endDate);
        return contrats.size();
    }

    @Override
    public String retrieveAndUpdateStatusContrat() {
    return null;
    }


    @Scheduled(cron = "0 0 13 */15 * *")
    @Override
    public void retrieveAllExpireIn15Days()
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        calendar.add(Calendar.DATE, 15);
        List<Contrat>  contrats =  iContratDao.findAllByArchiveFalseAndDateFinContratBetween(new Date(),calendar.getTime());
        log.info("Les contrats suivants vont être expirés dans 15 jours : ");
        contrats.forEach(c-> log.info("Contrat d'ID :" + c.getIdContrat() +" dans la specialite :" + c.getSpecialite()+" Date " +
                "d'expriration sera le : " + c.getDateFinContrat() ));

    }





 //  @Scheduled(cron = "*/15 * * * * *")
 //  public  void bonjour () { log.info("Heloo Ons");}  java -jar KaddemPrime

}
