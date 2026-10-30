package com.tecsup.petclinic.mappers;

import com.tecsup.petclinic.dtos.PetTypeDTO;
import com.tecsup.petclinic.entities.PetType;
import org.springframework.stereotype.Component;

@Component
public class PetTypeMapper {

    public PetTypeDTO mapToDto(PetType type) {
        if (type == null) return null;
        return PetTypeDTO.builder()
                .id(type.getId())
                .name(type.getName())
                .build();
    }

    public PetType mapToEntity(PetTypeDTO typeDTO) {
        if (typeDTO == null) return null;
        return PetType.builder()
                .id(typeDTO.getId())
                .name(typeDTO.getName())
                .build();
    }
}
