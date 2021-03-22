package com.ams.ms.generic.service;

import com.ams.ms.generic.repo.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GenericService<T,ID>   {
    @Autowired
    private GenericRepo<T,ID> genericRepo;

    public List<T> getAll() {
       return genericRepo.findAll();
    }

    public T getById(ID id) {
        return genericRepo.getOne(id);
    }

    public void deleteById(ID id) {
         genericRepo.deleteById(id);
    }

    public void softDeleteById(ID id) {
        genericRepo.softDeleteById(id);
    }
}
