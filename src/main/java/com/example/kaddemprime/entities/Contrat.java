package com.example.kaddemprime.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContrat ;
    @Temporal(TemporalType.DATE)
    Date dateDebutContrat ;
    @Temporal(TemporalType.DATE)
    Date dateFinContrat  ;
    @Enumerated(EnumType.STRING)
    Specialite specialite ;
    Boolean archive ;
    Integer montantContrat ;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    Etudiant etudiant ;


}
