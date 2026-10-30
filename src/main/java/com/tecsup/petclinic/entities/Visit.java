package com.tecsup.petclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pet_id")
    private Integer petId;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "description")
    private String description;
}
