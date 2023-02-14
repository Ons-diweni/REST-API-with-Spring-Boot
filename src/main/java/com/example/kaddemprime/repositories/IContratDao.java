package com.example.kaddemprime.repositories;

import com.example.kaddemprime.entities.Contrat;
import com.example.kaddemprime.entities.Equipe;
import com.example.kaddemprime.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface IContratDao extends JpaRepository<Contrat,Integer> {


    List<Contrat> findAllBySpecialite(Specialite s);
    List<Contrat> findAllBySpecialiteAndDateDebutContratGreaterThanEqualAndDateFinContratIsLessThanEqual(Specialite s, Date dDebut,Date dFin);
    List<Contrat> findAllByDateDebutContratGreaterThanEqualAndDateFinContratIsLessThanEqual(Date dDebut,Date dFin);
    List<Contrat> findContratsByArchiveIsFalseAndDateDebutContratGreaterThanEqualAndDateFinContratIsLessThanEqual(Date dDebut,Date dFin);

  /*  @Query("select c from Contrat c where (c.dateFinContrat > current_date ) and ( c.dateFinContrat - current_date <= 15)")
    List<Contrat> retrieveAllExpireIn15Days();*/


    List<Contrat> findAllByArchiveFalseAndDateFinContratBetween(Date dateDeb , Date dateFin);
}
