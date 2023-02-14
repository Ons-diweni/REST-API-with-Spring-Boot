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
public class Departement  implements Serializable {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer idDepart ;
 String nomDepart ;


 @OneToMany (mappedBy = "departement" , cascade = {CascadeType.PERSIST , CascadeType.REFRESH} , fetch = FetchType.LAZY)
 Set <Etudiant> etudiants ;

}
