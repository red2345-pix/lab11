package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import com.tecsup.petclinic.mappers.SpecialityMapper;
import com.tecsup.petclinic.repositories.SpecialityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;
    private final SpecialityMapper specialityMapper;

    @Override
    public SpecialityDTO create(SpecialityDTO specialityDTO) {
        Speciality newSpec = specialityRepository.save(specialityMapper.mapToEntity(specialityDTO));
        return specialityMapper.mapToDto(newSpec);
    }

    @Override
    public SpecialityDTO update(SpecialityDTO specialityDTO) {
        Speciality updatedSpec = specialityRepository.save(specialityMapper.mapToEntity(specialityDTO));
        return specialityMapper.mapToDto(updatedSpec);
    }

    @Override
    public void delete(Integer id) throws PetNotFoundException {
        SpecialityDTO spec = findById(id);
        specialityRepository.delete(this.specialityMapper.mapToEntity(spec));
    }

    @Override
    public SpecialityDTO findById(Integer id) throws PetNotFoundException {
        Optional<Speciality> spec = specialityRepository.findById(id);
        if (!spec.isPresent()) {
            throw new PetNotFoundException("Especialidad no encontrada con ID: " + id);
        }
        return this.specialityMapper.mapToDto(spec.get());
    }

    @Override
    public List<SpecialityDTO> findAll() {
        return specialityRepository.findAll()
                .stream()
                .map(this.specialityMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
