package com.example.kaddemprime.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailEquipe implements Serializable {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer  idDetailEquipe ;
 Integer salle ;
 String thematique ;

 @OneToOne( cascade = CascadeType.ALL)
 Equipe equipe ;

}
