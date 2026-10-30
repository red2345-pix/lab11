package com.tecsup.petclinic.mappers;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import org.springframework.stereotype.Component;

@Component
public class VetMapper {

    public VetDTO mapToDto(Vet vet) {
        if (vet == null) return null;
        return VetDTO.builder()
                .id(vet.getId())
                .firstName(vet.getFirstName())
                .lastName(vet.getLastName())
                .build();
    }

    public Vet mapToEntity(VetDTO vetDTO) {
        if (vetDTO == null) return null;
        return Vet.builder()
                .id(vetDTO.getId())
                .firstName(vetDTO.getFirstName())
                .lastName(vetDTO.getLastName())
                .build();
    }
}
