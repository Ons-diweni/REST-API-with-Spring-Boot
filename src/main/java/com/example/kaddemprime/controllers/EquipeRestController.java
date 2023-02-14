package com.example.kaddemprime.controllers;


import com.example.kaddemprime.entities.Equipe;
import com.example.kaddemprime.services.EquipeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {

    private final EquipeServices equipeServices;


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/equipe/getOneById
    @GetMapping("/idEquipe/{idEquipe}")
    public Equipe getOneById(@PathVariable("idEquipe") Integer idE)
    {return equipeServices.retrieveEquipe(idE);}

    //RessourceEndPoint:http://localhost:8085/KaddemPrime/equipe/getAll
    @GetMapping("/getAll")
    public List<Equipe> getAllEquipe ()
    { return equipeServices.retrieveAllEquipes();}

    //RessourceEndPoint:http://localhost:8085/KaddemPrime/equipe/deleteById/{idE}
    @DeleteMapping("/deleteById/{idE}")
    public void deleteEquipe( @PathVariable("idE") Integer idEquipe)
    { equipeServices.deleteEquipe(idEquipe);}

    //RessourceEndPoint:http://localhost:8085/KaddemPrime/equipe/addEquipe
    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe e)
    { return equipeServices.addOrUpdateEquipe(e);}

    //RessourceEndPoint:http://localhost:8085/KaddemPrime/equipe/updateEquipe
    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody  Equipe e)
    { return equipeServices.addOrUpdateEquipe(e);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/equipe/faireEvoluerEquipes
    @PostMapping("/faireEvoluerEquipes")
    public void faireEvoluerEquipes()
    {equipeServices.faireEvoluerEquipes();}


    }
