package com.ams.ms.generic.controller;

import com.ams.ms.generic.pojo.APIResponse;
import com.ams.ms.generic.pojo.CustomMessageSource;
import com.ams.ms.generic.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public  class GenericControllerHelper<T,ID> {
    @Autowired
    private  GenericService<T,ID> genericService;
    @Autowired
    private  APIResponse apiResponse;
    @Autowired
    private CustomMessageSource messageSource;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam Integer status){
        return apiResponse.getSuccess(messageSource.get("get.success"),genericService.getAll());
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable ID id){
        return apiResponse.getSuccess(messageSource.get("get.success"),genericService.getById(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ID id){
        genericService.deleteById(id);
        return apiResponse.deleteSuccess(messageSource.get("delete.success"),null);
    }
    @DeleteMapping("softDelete/{id}")
    public ResponseEntity<?> softDeleteById(@PathVariable ID id){
        genericService.softDeleteById(id);
        return apiResponse.deleteSuccess(messageSource.get("delete.success"),null);
    }




}
