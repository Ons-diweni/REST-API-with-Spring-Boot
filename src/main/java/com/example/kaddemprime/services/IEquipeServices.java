package com.example.kaddemprime.services;

import com.example.kaddemprime.entities.Equipe;

import java.util.List;

public interface IEquipeServices {

    List <Equipe> retrieveAllEquipes();

    Equipe addOrUpdateEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe retrieveEquipe (Integer idEquipe);

    void deleteEquipe (Integer idEquipe);

    void faireEvoluerEquipes();
}
