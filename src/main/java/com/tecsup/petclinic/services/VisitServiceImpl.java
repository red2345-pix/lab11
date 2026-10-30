package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import com.tecsup.petclinic.mappers.VisitMapper;
import com.tecsup.petclinic.repositories.VisitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;

    @Override
    public VisitDTO create(VisitDTO visitDTO) {
        Visit newVisit = visitRepository.save(visitMapper.mapToEntity(visitDTO));
        return visitMapper.mapToDto(newVisit);
    }

    @Override
    public VisitDTO update(VisitDTO visitDTO) {
        Visit updatedVisit = visitRepository.save(visitMapper.mapToEntity(visitDTO));
        return visitMapper.mapToDto(updatedVisit);
    }

    @Override
    public void delete(Integer id) throws PetNotFoundException {
        VisitDTO visit = findById(id);
        visitRepository.delete(this.visitMapper.mapToEntity(visit));
    }

    @Override
    public VisitDTO findById(Integer id) throws PetNotFoundException {
        Optional<Visit> visit = visitRepository.findById(id);
        if (!visit.isPresent()) {
            throw new PetNotFoundException("Visita no encontrada con ID: " + id);
        }
        return this.visitMapper.mapToDto(visit.get());
    }

    @Override
    public List<VisitDTO> findAll() {
        return visitRepository.findAll()
                .stream()
                .map(this.visitMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
