package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    public void testCrudVisit() throws PetNotFoundException {
        // 1. CREACIÓN
        VisitDTO nuevaVisita = VisitDTO.builder()
                .petId(1) // Relacionado con mascota por defecto ID 1
                .visitDate(LocalDate.now())
                .description("Chequeo rutinario de vacunas anuales")
                .build();
        VisitDTO visitaGuardada = visitService.create(nuevaVisita);
        assertNotNull(visitaGuardada.getId());

        // 2. BÚSQUEDA
        VisitDTO visitaEncontrada = visitService.findById(visitaGuardada.getId());
        assertEquals("Chequeo rutinario de vacunas anuales", visitaEncontrada.getDescription());

        // 3. ACTUALIZACIÓN
        visitaEncontrada.setDescription("Tratamiento post-operatorio corregido");
        VisitDTO visitaActualizada = visitService.update(visitaEncontrada);
        assertEquals("Tratamiento post-operatorio corregido", visitaActualizada.getDescription());

        // 4. ELIMINACIÓN
        visitService.delete(visitaActualizada.getId());
        assertThrows(PetNotFoundException.class, () -> visitService.findById(visitaActualizada.getId()));
    }
}
