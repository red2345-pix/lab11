package com.tecsup.petclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// CORRECCIÓN AQUÍ: Asegúrate de importar desde jakarta.persistence
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "vets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vet {

    @Id // <-- ESTA ANOTACIÓN ES LA QUE FALTA O TIENE UN IMPORT ERRÓNEO
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
