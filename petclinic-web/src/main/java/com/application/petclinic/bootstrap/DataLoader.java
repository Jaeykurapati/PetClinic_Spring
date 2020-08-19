package com.application.petclinic.bootstrap;

import com.application.petclinic.model.Owner;
import com.application.petclinic.model.Vet;
import com.application.petclinic.services.OwnerService;
import com.application.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {


        Owner owner1 = new Owner();
        owner1.setFirstName("Jhon");
        owner1.setLastName("Thomas");
        System.out.println(owner1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("David");
        owner2.setLastName("James");

        ownerService.save(owner2);
        System.out.println(owner2);
        System.out.println("Owners loaded");


        Vet vet1 = new Vet();
        vet1.setFirstName("Master");
        vet1.setLastName("Thomas");
        System.out.println(vet1);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Suizi");
        vet2.setLastName("Pearson");
        System.out.println(vet2);
        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}
