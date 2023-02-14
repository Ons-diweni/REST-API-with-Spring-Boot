package com.example.kaddemprime.controllers;


import com.example.kaddemprime.entities.Departement;
import com.example.kaddemprime.entities.Equipe;
import com.example.kaddemprime.services.DepartementServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/departement")
@RequiredArgsConstructor
public class DepartementRestController {

private final DepartementServices departementServices;


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/departement/add
    @PostMapping("/addDepartement")
    public Departement addDepartement(@RequestBody Departement d)
    { return  departementServices.addOrUpdateDepartement(d);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/departement/all
    @GetMapping("/getAllDepartement")
    public List<Departement> getAllDepartement ()
    { return departementServices.retrieveAllDepartements();}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/departement/getOneById/{idD}
    @GetMapping("/getOneById/{idD}")
    public Departement getDepartementById(@PathVariable("idD") Integer id)
    {return departementServices.retrieveDepartement(id);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/departement/deleteById/{id}
    @DeleteMapping("/deleteById/{id}")
    public void deleteDepartement(@PathVariable("id")  Integer idD)
    { departementServices.deleteDepartement(idD);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/departement/updateDepartement
    @PutMapping("/updateDepartement")
     public Departement updateDepartement(@RequestBody  Departement d)
     {return departementServices.addOrUpdateDepartement( d);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/departement/retrieveDepartementsByUniversite/{idU}
    @GetMapping("/retrieveDepartementsByUniversite/{idU}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idU") Integer idUniversite)
    {return departementServices.retrieveDepartementsByUniversite(idUniversite); }




    }
