package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.PetTypeDTO;
import com.tecsup.petclinic.entities.PetType;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import com.tecsup.petclinic.mappers.PetTypeMapper;
import com.tecsup.petclinic.repositories.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeRepository petTypeRepository;
    private final PetTypeMapper petTypeMapper;

    @Override
    public PetTypeDTO create(PetTypeDTO petTypeDTO) {
        PetType newType = petTypeRepository.save(petTypeMapper.mapToEntity(petTypeDTO));
        return petTypeMapper.mapToDto(newType);
    }

    @Override
    public PetTypeDTO update(PetTypeDTO petTypeDTO) {
        PetType updatedType = petTypeRepository.save(petTypeMapper.mapToEntity(petTypeDTO));
        return petTypeMapper.mapToDto(updatedType);
    }

    @Override
    public void delete(Integer id) throws PetNotFoundException {
        PetTypeDTO type = findById(id);
        petTypeRepository.delete(this.petTypeMapper.mapToEntity(type));
    }

    @Override
    public PetTypeDTO findById(Integer id) throws PetNotFoundException {
        Optional<PetType> type = petTypeRepository.findById(id);
        if (!type.isPresent()) {
            throw new PetNotFoundException("Tipo de mascota no encontrado con ID: " + id);
        }
        return this.petTypeMapper.mapToDto(type.get());
    }

    @Override
    public List<PetTypeDTO> findAll() {
        return petTypeRepository.findAll()
                .stream()
                .map(this.petTypeMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
