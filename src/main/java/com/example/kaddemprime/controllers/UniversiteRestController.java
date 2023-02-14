package com.example.kaddemprime.controllers;

import com.example.kaddemprime.entities.Universite;
import com.example.kaddemprime.services.UniversiteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("universite")
public class UniversiteRestController {

    private final UniversiteServices universiteServices ;

    //RessourceEndPoint:http://localhost:8085/KaddemPrime/universite/getUnivById/{idU}
    @GetMapping("/getUnivById/{idU}")
    public Universite getUniversiteById (@PathVariable("idU") Integer idUniv)
    {return universiteServices.retrieveUniversite(idUniv);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/universite/getAllUniversite
    @GetMapping("/getAllUniversite")
    public List<Universite> getAllUniversite()
    { return  universiteServices.retrieveAllUniversites();}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/universite/addUniversite
    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u)
    {return  universiteServices.addOrUpdateUniversite(u);}


    //RessourceEndPoint:http://localhost:8085/KaddemPrime/universite/deleteUniversite/{idUniv}
    @DeleteMapping("/deleteUniversite/{idUniv}")
    public void deleteUniversite(Integer idU)
    { universiteServices.deleteUniversite(idU);}

    //RessourceEndPoint:http://localhost:8085/KaddemPrime/universite/affectDepartToUniv/{idD}/{idU}
    @PostMapping("/affectDepartToUniv/{idD}/{idU}")
    public Universite affectDepartToUniv(@PathVariable("idD")  Integer idD,@PathVariable("idU") Integer idU)
    {return  universiteServices.affectDepartToUniv(idD ,idU); }

    //RessourceEndPoint:http://localhost:8085/KaddemPrime/universite/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}
    @GetMapping("/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,@PathVariable ("endDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
    { return universiteServices.getChiffreAffaireEntreDeuxDate(startDate,endDate); }



    }
