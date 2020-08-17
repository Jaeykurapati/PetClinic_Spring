package com.application.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    private Map<ID, T> map = new HashMap<ID, T>();

    Set<T> findAll(){
        return new HashSet<T>(map.values());
    }

    T findById(ID id){
        return (T) map.get(id);
    }

    T save(ID id, T object){
        map.put(id,object);
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }
}
