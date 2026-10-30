package com.tecsup.petclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "owners")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address") // <-- Asegura este mapeo
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone") // <-- Asegura este mapeo (a veces es 'telephone' o 'phone')
    private String telephone;
}
