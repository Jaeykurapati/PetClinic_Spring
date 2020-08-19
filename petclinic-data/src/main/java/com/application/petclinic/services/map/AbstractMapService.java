package com.application.petclinic.services.map;

import com.application.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private Map<Long, T> map = new HashMap<Long, T>();

    Set<T> findAll(){
        return new HashSet<T>(map.values());
    }

    T findById(ID id){
        return (T) map.get(id);
    }

    T save(T object){
        if(object!=null){
            if(object.getId()==null){
                object.setId(getNextId());
                map.put(object.getId(),object);
            }
        }
        else {
            throw new NullPointerException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

    Long getNextId(){
        try{
            return Collections.max(map.keySet())+1;
        }
        catch (NoSuchElementException e){
            return 5L;
        }

    }
}
