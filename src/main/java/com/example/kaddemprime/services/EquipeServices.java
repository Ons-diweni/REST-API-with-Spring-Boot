package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.Contrat;
import com.example.kaddemprime.entities.Equipe;
import com.example.kaddemprime.entities.Etudiant;
import com.example.kaddemprime.entities.Niveau;
import com.example.kaddemprime.repositories.IEquipeDao;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class EquipeServices implements IEquipeServices{

    private final IEquipeDao iEquipeDao ;


    @Override
    public List<Equipe> retrieveAllEquipes()
    {return iEquipeDao.findAll();}

    @Override
    public Equipe addOrUpdateEquipe(Equipe e)
    { return iEquipeDao.save(e);}

    @Override
    public Equipe retrieveEquipe(Integer idEquipe)
    {return iEquipeDao.findById(idEquipe).orElse(null);}

    @Override
    public void deleteEquipe(Integer idEquipe)
    { iEquipeDao.deleteById(idEquipe);}


    @Scheduled(cron = "0 0 13 */15 * *")
    @Override
    public void faireEvoluerEquipes() {
        int pass = 0 ;
     List<Equipe> juniors = iEquipeDao.findAllByNiveau(Niveau.JUNIOR);
     List<Equipe> seniors = iEquipeDao.findAllByNiveau(Niveau.SENIOR);

     for(Equipe e:juniors)
      {
        for(Etudiant etudiant : e.getEtudiants())
       { int NbContratplusAn = 0;
         for(Contrat c: etudiant.getContrats()) {
             if (Days.daysBetween(new DateTime(c.getDateDebutContrat()), new DateTime(c.getDateFinContrat())).getDays() >= 365)
             { NbContratplusAn++; break ;  }  }
         if(NbContratplusAn >= 1 ) {pass = pass +1 ;}  }
         if(pass >= 3) { e.setNiveau(Niveau.SENIOR); iEquipeDao.save(e);}
      }
        pass = 0 ;
        for(Equipe e:seniors)
        {
            for(Etudiant etudiant : e.getEtudiants())
            {  int NbContratplusAn = 0;
                for(Contrat c: etudiant.getContrats()) {
                    if (Days.daysBetween(new DateTime(c.getDateDebutContrat()), new DateTime(c.getDateFinContrat())).getDays() >= 365)
                    { NbContratplusAn++;  break ;} }
                if(NbContratplusAn >= 1 ) {pass = pass+1;}  }
            if(pass >= 3) { e.setNiveau(Niveau.EXPERT); iEquipeDao.save(e);}
        }

    }






}
