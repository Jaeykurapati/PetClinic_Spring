package com.application.petclinic.bootstrap;

import com.application.petclinic.model.*;
import com.application.petclinic.services.OwnerService;
import com.application.petclinic.services.PetTypeService;
import com.application.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesServices specialitiesServices;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesServices specialitiesServices) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesServices = specialitiesServices;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().size()==0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedPetDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedPetCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jhon");
        owner1.setLastName("Thomas");
        owner1.setAddress("1234 St");
        owner1.setCity("City Miami");
        owner1.setTelephone("12341123123");

        Pet jhonpet = new Pet();
        jhonpet.setPetType(savedPetCat);
        jhonpet.setBirthDate(LocalDate.now());
        jhonpet.setOwner(owner1);
        jhonpet.setName("puppy");
        owner1.getPets().add(jhonpet);
        System.out.println(owner1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("David");
        owner2.setLastName("James");
        owner1.setAddress("1234 St");
        owner1.setCity("City Miami");
        owner1.setTelephone("12341123123");

        Pet davidCat = new Pet();
        davidCat.setPetType(savedPetCat);
        davidCat.setBirthDate(LocalDate.now());
        davidCat.setOwner(owner2);
        davidCat.setName("puppy cat david");
        owner2.getPets().add(jhonpet);


        ownerService.save(owner2);
        System.out.println(owner2);
        System.out.println("Owners loaded");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesServices.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialitiesServices.save(radiology);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialitiesServices.save(radiology);

        Vet vet1 = new Vet();
        vet1.setFirstName("Master");
        vet1.setLastName("Thomas");
        vet1.getSpecialities().add(savedRadiology);
        System.out.println(vet1);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Suizi");
        vet2.setLastName("Pearson");
        vet2.getSpecialities().add(savedDentistry);
        System.out.println(vet2);
        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}
