package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.PetTypeDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PetTypeServiceTest {

	@Autowired
	private PetTypeService petTypeService;

	@Test
	public void testCrudPetType() throws PetNotFoundException {
		// 1. CREACIÓN
		PetTypeDTO nuevoTipo = PetTypeDTO.builder()
				.name("Bird")
				.build();
		PetTypeDTO tipoGuardado = petTypeService.create(nuevoTipo);
		assertNotNull(tipoGuardado.getId());

		// 2. BÚSQUEDA
		PetTypeDTO tipoEncontrado = petTypeService.findById(tipoGuardado.getId());
		assertEquals("Bird", tipoEncontrado.getName());

		// 3. ACTUALIZACIÓN
		tipoEncontrado.setName("Exotic Bird");
		PetTypeDTO tipoActualizado = petTypeService.update(tipoEncontrado);
		assertEquals("Exotic Bird", tipoActualizado.getName());

		// 4. ELIMINACIÓN
		petTypeService.delete(tipoActualizado.getId());
		assertThrows(PetNotFoundException.class, () -> petTypeService.findById(tipoActualizado.getId()));
	}
}
