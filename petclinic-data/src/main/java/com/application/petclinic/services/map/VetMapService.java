package com.application.petclinic.services.map;

import com.application.petclinic.model.PetType;
import com.application.petclinic.model.Speciality;
import com.application.petclinic.model.Vet;
import com.application.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","springmap"})
public class VetMapService extends AbstractMapService<Vet, Long>  implements VetService {

    private final SpecialityMapServices specialityMapServices;

    public VetMapService(SpecialityMapServices specialityMapServices) {
        this.specialityMapServices = specialityMapServices;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities()!=null){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null){
                    Speciality savedSpeciality = specialityMapServices.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
