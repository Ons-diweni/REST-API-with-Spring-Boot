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
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUniv ;
    String nomUniv  ;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    Set<Departement> departements ;


}
