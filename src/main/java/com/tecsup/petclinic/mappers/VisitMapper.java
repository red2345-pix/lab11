package com.tecsup.petclinic.mappers;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.entities.Visit;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {

    public VisitDTO mapToDto(Visit visit) {
        if (visit == null) return null;
        return VisitDTO.builder()
                .id(visit.getId())
                .petId(visit.getPetId())
                .visitDate(visit.getVisitDate())
                .description(visit.getDescription())
                .build();
    }

    public Visit mapToEntity(VisitDTO visitDTO) {
        if (visitDTO == null) return null;
        return Visit.builder()
                .id(visitDTO.getId())
                .petId(visitDTO.getPetId())
                .visitDate(visitDTO.getVisitDate())
                .description(visitDTO.getDescription())
                .build();
    }
}
