package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VetSpecialtyServiceTest {

    @Autowired
    private VetService vetService;

    @Autowired
    private SpecialityService specialityService;

    @Test
    public void testAsignacionYBusquedaEspecialidades() throws PetNotFoundException {
        // 1. ASIGNACIÓN: Asociamos un veterinario con una especialidad
        Integer vetId = 1;
        Integer specId = 1;
        vetService.addSpeciality(vetId, specId);

        // 2. BÚSQUEDA DE ESPECIALIDADES POR VETERINARIO
        List<SpecialityDTO> especialidadesDelVet = vetService.findByVetId(vetId);
        assertFalse(especialidadesDelVet.isEmpty());
        assertEquals("Dentistry", especialidadesDelVet.get(0).getName());

        // 3. BÚSQUEDA DE VETERINARIOS POR ESPECIALIDAD
        List<VetDTO> veterinariosPorEspecialidad = vetService.findBySpecialityId(specId);
        assertFalse(veterinariosPorEspecialidad.isEmpty());
        assertEquals("Ríos", veterinariosPorEspecialidad.get(0).getLastName());

        // 4. ELIMINACIÓN DE LA RELACIÓN VETERINARIO-ESPECIALIDAD
        vetService.removeSpeciality(vetId, specId);
        // Validamos que el proceso se ejecute de forma exitosa sin lanzar excepciones
        assertDoesNotThrow(() -> vetService.removeSpeciality(vetId, specId));
    }
}
