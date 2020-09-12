package com.application.petclinic.services.map;

import com.application.petclinic.services.SpecialitiesServices;
import com.application.petclinic.model.Speciality;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","springmap"})
public class SpecialityMapServices extends AbstractMapService<Speciality,Long> implements SpecialitiesServices {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
