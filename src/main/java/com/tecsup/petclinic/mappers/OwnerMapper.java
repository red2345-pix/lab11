package com.tecsup.petclinic.mappers;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    public OwnerDTO mapToDto(Owner owner) {
        if (owner == null) return null;
        return OwnerDTO.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .address(owner.getAddress())
                .city(owner.getCity())
                .telephone(owner.getTelephone())
                .build();
    }

    public Owner mapToEntity(OwnerDTO ownerDTO) {
        if (ownerDTO == null) return null;
        return Owner.builder()
                .id(ownerDTO.getId())
                .firstName(ownerDTO.getFirstName())
                .lastName(ownerDTO.getLastName())
                .address(ownerDTO.getAddress())
                .city(ownerDTO.getCity())
                .telephone(ownerDTO.getTelephone())
                .build();
    }
}
