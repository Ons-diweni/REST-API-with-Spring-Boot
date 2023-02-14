package com.example.kaddemprime.controllers;

import com.example.kaddemprime.entities.Contrat;
import com.example.kaddemprime.entities.Etudiant;
import com.example.kaddemprime.services.EtudiantServices;
import com.example.kaddemprime.utilities.WrapperEtudiantContrat;
import com.example.kaddemprime.utilities.WrapperEtudiantEquipe;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
     private final EtudiantServices etudiantServices;

     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/add
     @PostMapping("/add")
     public Etudiant addEtudiant (@RequestBody Etudiant e)
     {return etudiantServices.addOrUpdateEtudiant(e);}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/getAll
     @GetMapping("/getAll")
     public List <Etudiant> getAllEtudiant ()
     { return etudiantServices.retrieveAllEtudiants();}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/deleteById/{idE}
     @DeleteMapping("/deleteById/{idE}")
     public void deleteEtudiant( @PathVariable("idE") Integer idEtudiant)
     {  etudiantServices.removeEtudiant(idEtudiant); }


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/getOneById/{id}
     @GetMapping("/getOneById/{id}")
     public Etudiant getOneById (@PathVariable("id")  Integer idE)
     { return etudiantServices.retrieveEtudiant(idE);}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/updateEtudiant
     @PutMapping("/updateEtudiant")
     public Etudiant updateEtudiant (@RequestBody Etudiant e)
     { return  etudiantServices.addOrUpdateEtudiant(e);}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/addEtudiantAddEquipeAvecAffec
     @PostMapping("/addEtudiantAddEquipeAvecAffec")
     public Etudiant addEtudiantAddEquipeAvecAffec(@RequestBody WrapperEtudiantEquipe wrapperEtudiantEquipe)
     {return etudiantServices.addEtudiantAddEquipeAvecAffec(wrapperEtudiantEquipe.e,wrapperEtudiantEquipe.equipe);}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/addEtudiantAndAffectToContrat/{id}
     @PostMapping("/addEtudiantAndAffectToContrat/{id}")
     public Etudiant addEtudiantAndAffectToContrat(@RequestBody  Etudiant etudiant,@PathVariable("id") Integer idC)
     { return etudiantServices.addEtudiantAndAffectToContrat(etudiant,idC);}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/AffectEtudiantToContrat/{idE}/{idC}
     @PostMapping("/AffectEtudiantToContrat/{idE}/{idC}")
     public Etudiant AffectEtudiantToContrat(@PathVariable("idE") Integer idE,@PathVariable("idC") Integer idC)
     { return etudiantServices.AffectEtudiantToContrat(idE,idC);   }


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/addEtudiantAndAffectToContrat/{id}
     @PostMapping("/AffectEtudiantToDepart/{idE}/{idD}")
     public void AffectEtudiantToDepart(@PathVariable("idE")  Integer idE,@PathVariable("idD") Integer idD)
     {  etudiantServices.AffectEtudiantToDepart(idE,idD);}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/addEtudiantAddContratAvecAffec
     @PostMapping("/addEtudiantAddContratAvecAffec")
     public Etudiant addEtudiantAddContratAvecAffec(@RequestBody WrapperEtudiantContrat wrapperEtudiantContrat)
     { return  etudiantServices.addEtudiantAddContratAvecAffec(wrapperEtudiantContrat.etudiant,wrapperEtudiantContrat.contrat);}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/addAndAssignEtudiantToEquipeAndContract/{idC}/{idE}
     @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idC}/{idE}")
     public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idC") Integer idContrat,@PathVariable("idE") Integer idEquipe)
     { return  etudiantServices.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/getEtudiantsByDepartement/{idD}
     @GetMapping("/getEtudiantsByDepartement/{idD}")
     public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idD") Integer idDepartement)
     { return  etudiantServices.getEtudiantsByDepartement(idDepartement);}


     //RessourceEndPoint:http://localhost:8085/KaddemPrime/etudiant/affectEtudiantToEquipe/{idEtudiant}/{idEquipe}
     @PostMapping("/affectEtudiantToEquipe/{idEtudiant}/{idEquipe}")
     public Etudiant affectEtudiantToEquipe(@PathVariable("idEtudiant") Integer idEtudiant,@PathVariable("idEquipe") Integer idEquipe)
     {return etudiantServices.affectEtudiantToEquipe(idEtudiant,idEquipe);}


     }
