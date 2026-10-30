package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import java.util.List;

public interface VisitService {
    VisitDTO create(VisitDTO visitDTO);
    VisitDTO update(VisitDTO visitDTO);
    void delete(Integer id) throws PetNotFoundException;
    VisitDTO findById(Integer id) throws PetNotFoundException;
    List<VisitDTO> findAll();
}
