package com.example.kaddemprime.controllers;


import com.example.kaddemprime.entities.Contrat;
import com.example.kaddemprime.services.ContratServices;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/contrat")
@RestController
public class ContratRestController {

    private final ContratServices contratServices ;


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/contrat/add
    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat ce)
    {return contratServices.addOrUpdateContrat(ce);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/contrat/update
    @PutMapping("/updateContrat")
    public Contrat updateContrat (@RequestBody Contrat ce )
    { return  contratServices.addOrUpdateContrat(ce);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/contrat/deleteById/{idC}
    @DeleteMapping("/deleteById/{idC}")
    public void deleteContrat (@PathVariable("idC") Integer idC)
    { contratServices.removeContrat(idC);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/contrat/getAll
    @GetMapping("/getAll")
    public List<Contrat> getAllContrat()
    { return contratServices.retrieveAllContrats();}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/contrat/getOneById/{idC}
    @GetMapping("/getById/{idC}")
    public Contrat getById(@PathVariable("idC") Integer id)
    {   return contratServices.retrieveContrat(id);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/contrat/affectContratToEtudiant/{nom}/{prenom}
    @PostMapping("/affectContratToEtudiant/{nom}/{prenom}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce,@PathVariable("nom") String nomE,@PathVariable("prenom") String prenomE)
    { return  contratServices.affectContratToEtudiant(ce,nomE,prenomE);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/contrat/nbContratsValides/{startDate}/{endDate}
    @GetMapping("nbContratsValides/{startDate}/{endDate}")
    public Integer nbContratsValides(@PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,@PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
    { return  contratServices.nbContratsValides(startDate,endDate);}





    }
