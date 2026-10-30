package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException; // Usamos la excepción existente para simplificar
import java.util.List;

public interface VetService {
    VetDTO create(VetDTO vetDTO);
    VetDTO update(VetDTO vetDTO);
    void delete(Integer id) throws PetNotFoundException;
    VetDTO findById(Integer id) throws PetNotFoundException;
    List<VetDTO> findAll();
    void addSpeciality(Integer vetId, Integer specId) throws com.tecsup.petclinic.exceptions.PetNotFoundException;
    void removeSpeciality(Integer vetId, Integer specId) throws com.tecsup.petclinic.exceptions.PetNotFoundException;
    java.util.List<com.tecsup.petclinic.dtos.SpecialityDTO> findByVetId(Integer vetId) throws com.tecsup.petclinic.exceptions.PetNotFoundException;
    java.util.List<VetDTO> findBySpecialityId(Integer specId) throws com.tecsup.petclinic.exceptions.PetNotFoundException;
}
