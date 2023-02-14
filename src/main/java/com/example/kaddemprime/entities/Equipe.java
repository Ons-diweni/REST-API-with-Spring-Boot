package com.example.kaddemprime.entities;

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
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEquipe ;
    String nomEquipe ;
    @Enumerated(EnumType.STRING)
    Niveau niveau ;

    @OneToOne (mappedBy = "equipe"  , cascade = CascadeType.ALL)
    DetailEquipe detailEquipe ;

    @ManyToMany(mappedBy = "equipes" , cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    Set<Etudiant> etudiants ;


}
