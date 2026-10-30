package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testCrudVet() throws PetNotFoundException {
        // 1. CREACIÓN
        VetDTO nuevoVet = VetDTO.builder()
                .firstName("Carlos")
                .lastName("Mendoza")
                .build();
        VetDTO vetGuardado = vetService.create(nuevoVet);
        assertNotNull(vetGuardado.getId());
        assertEquals("Carlos", vetGuardado.getFirstName());

        // 2. BÚSQUEDA
        VetDTO vetEncontrado = vetService.findById(vetGuardado.getId());
        assertEquals("Mendoza", vetEncontrado.getLastName());

        // 3. ACTUALIZACIÓN
        vetEncontrado.setLastName("Mendoza Silva");
        VetDTO vetActualizado = vetService.update(vetEncontrado);
        assertEquals("Mendoza Silva", vetActualizado.getLastName());

        // 4. ELIMINACIÓN
        vetService.delete(vetActualizado.getId());
        assertThrows(PetNotFoundException.class, () -> vetService.findById(vetActualizado.getId()));
    }
}
