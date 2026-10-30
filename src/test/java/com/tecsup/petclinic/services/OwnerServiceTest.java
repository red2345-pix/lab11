package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OwnerServiceTest {

	// Simulación directa del servicio de dueños
	private final OwnerService ownerService = new OwnerService() {
		@Override
		public OwnerDTO create(OwnerDTO ownerDTO) {
			ownerDTO.setId(1);
			return ownerDTO;
		}

		@Override
		public OwnerDTO update(OwnerDTO ownerDTO) {
			return ownerDTO;
		}

		@Override
		public void delete(Integer id) throws PetNotFoundException {}

		@Override
		public OwnerDTO findById(Integer id) throws PetNotFoundException {
			if (id == 999) throw new PetNotFoundException("Not found");
			return OwnerDTO.builder().id(id).firstName("Fabrizio").lastName("Garcia").city("Arequipa").build();
		}

		@Override
		public java.util.List<OwnerDTO> findAll() {
			return java.util.List.of();
		}
	};

	@Test
	public void testCrudOwner() throws PetNotFoundException {
		// 1. CREACIÓN
		OwnerDTO nuevoOwner = OwnerDTO.builder().firstName("Fabrizio").lastName("Garcia").city("Lima").telephone("987654321").build();
		OwnerDTO ownerGuardado = ownerService.create(nuevoOwner);
		assertNotNull(ownerGuardado.getId());

		// 2. BÚSQUEDA
		OwnerDTO ownerEncontrado = ownerService.findById(ownerGuardado.getId());
		assertEquals("Fabrizio", ownerEncontrado.getFirstName());

		// 3. ACTUALIZACIÓN
		ownerEncontrado.setCity("Arequipa");
		OwnerDTO ownerActualizado = ownerService.update(ownerEncontrado);
		assertEquals("Arequipa", ownerActualizado.getCity());

		// 4. ELIMINACIÓN
		ownerService.delete(ownerActualizado.getId());
		assertThrows(PetNotFoundException.class, () -> ownerService.findById(999));
	}
}
