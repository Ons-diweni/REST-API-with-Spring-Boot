package com.example.kaddemprime.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEtudiant ;
    String prenomE ;
    // @JsonProperty("name") sert à changer le nom de la proprietè lors de la serialisation From Ojbect to json
    String nomE ;
    @Enumerated(EnumType.STRING)
    Option option ;

    @JsonIgnore
    @OneToMany(mappedBy = "etudiant" , cascade = CascadeType.ALL , fetch = FetchType.LAZY) // Association Etudiant-Contrat - Etudiant child
    Set <Contrat> contrats ;

    @JsonIgnore
    @ManyToOne (cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    Departement departement ;

    @JsonIgnore
    @ManyToMany (cascade = CascadeType.PERSIST , fetch =  FetchType.LAZY)
    Set<Equipe> equipes ;

}
