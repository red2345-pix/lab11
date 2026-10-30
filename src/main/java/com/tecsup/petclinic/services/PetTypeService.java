package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.PetTypeDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import java.util.List;

public interface PetTypeService {
    PetTypeDTO create(PetTypeDTO petTypeDTO);
    PetTypeDTO update(PetTypeDTO petTypeDTO);
    void delete(Integer id) throws PetNotFoundException;
    PetTypeDTO findById(Integer id) throws PetNotFoundException;
    List<PetTypeDTO> findAll();
}
