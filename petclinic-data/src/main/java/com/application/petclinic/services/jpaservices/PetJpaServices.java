package com.application.petclinic.services.jpaservices;

import com.application.petclinic.model.Pet;
import com.application.petclinic.repositories.PetRepository;
import com.application.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springjpa")
public class PetJpaServices implements PetService {

    private final PetRepository petRepository;

    public PetJpaServices(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> set = new HashSet<>();
        petRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
