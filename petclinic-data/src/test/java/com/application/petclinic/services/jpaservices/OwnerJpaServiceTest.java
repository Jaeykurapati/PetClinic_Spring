package com.application.petclinic.services.jpaservices;

import com.application.petclinic.model.Owner;
import com.application.petclinic.repositories.OwnerRepository;
import com.application.petclinic.repositories.PetRepository;
import com.application.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    private final String lastName = "Smith";

    Owner storedOwner;

    @BeforeEach
    void setUp() {
        storedOwner = Owner.builder().id(1L).lastName(lastName).build();
    }

    @Test
    void findByLastName() {

        when(ownerJpaService.findByLastName(any())).thenReturn(storedOwner);
        Owner smith = ownerJpaService.findByLastName(lastName);
        assertEquals(lastName,smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        Set<Owner> storedOwners = new HashSet<>();
        storedOwners.add(storedOwner);
        storedOwners.add(Owner.builder().id(2L).lastName("Mike").build());

        when(ownerJpaService.findAll()).thenReturn(storedOwners);

        Set<Owner> result = ownerJpaService.findAll();
        assertEquals(2,result.size());
        assertNotNull(result);
        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(storedOwner));
        Owner result = ownerJpaService.findById(1L);
        assertEquals(result,storedOwner);
    }

    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner result = ownerJpaService.findById(1L);
        assertNull(result);
    }

    @Test
    void save() {
        Owner result= Owner.builder().id(2L).lastName("Jhon").build();
        when(ownerJpaService.save(any())).thenReturn(result);
        assertEquals(result,ownerJpaService.save(result));
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {

        ownerJpaService.delete(storedOwner);
        verify(ownerRepository).delete(storedOwner);
    }

    @Test
    void deleteById() {

        ownerJpaService.deleteById(storedOwner.getId());

        verify(ownerRepository).deleteById(anyLong());
    }
}