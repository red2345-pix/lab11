package com.tecsup.petclinic.mappers;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import org.springframework.stereotype.Component;

@Component
public class SpecialityMapper {

    // Asegúrate de que se llame exactamente 'mapToDto'
    public SpecialityDTO mapToDto(Speciality speciality) {
        if (speciality == null) return null;
        return SpecialityDTO.builder()
                .id(speciality.getId())
                .name(speciality.getName())
                .build();
    }

    // Asegúrate de que se llame exactamente 'mapToEntity'
    public Speciality mapToEntity(SpecialityDTO specialityDTO) {
        if (specialityDTO == null) return null;
        return Speciality.builder()
                .id(specialityDTO.getId())
                .name(specialityDTO.getName())
                .build();
    }
}
