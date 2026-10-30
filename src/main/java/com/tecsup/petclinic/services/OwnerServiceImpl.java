package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import com.tecsup.petclinic.mappers.OwnerMapper;
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public OwnerDTO create(OwnerDTO ownerDTO) {
        Owner newOwner = ownerRepository.save(ownerMapper.mapToEntity(ownerDTO));
        return ownerMapper.mapToDto(newOwner);
    }

    @Override
    public OwnerDTO update(OwnerDTO ownerDTO) {
        Owner updatedOwner = ownerRepository.save(ownerMapper.mapToEntity(ownerDTO));
        return ownerMapper.mapToDto(updatedOwner);
    }

    @Override
    public void delete(Integer id) throws PetNotFoundException {
        OwnerDTO owner = findById(id);
        ownerRepository.delete(this.ownerMapper.mapToEntity(owner));
    }

    @Override
    public OwnerDTO findById(Integer id) throws PetNotFoundException {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (!owner.isPresent()) {
            throw new PetNotFoundException("Dueño no encontrado con ID: " + id);
        }
        return this.ownerMapper.mapToDto(owner.get());
    }

    @Override
    public List<OwnerDTO> findAll() {
        return ownerRepository.findAll()
                .stream()
                .map(this.ownerMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
