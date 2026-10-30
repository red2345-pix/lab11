package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import java.util.List;

public interface SpecialityService {
    SpecialityDTO create(SpecialityDTO specialityDTO);
    SpecialityDTO update(SpecialityDTO specialityDTO);
    void delete(Integer id) throws PetNotFoundException;
    SpecialityDTO findById(Integer id) throws PetNotFoundException;
    List<SpecialityDTO> findAll();
}
