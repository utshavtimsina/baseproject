package com.ams.ms.generic.controller;

import com.ams.ms.generic.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class GenericController<T,Y,ID> extends GenericControllerHelper<T,ID> {
    @Autowired
     private  GenericService<T,ID> genericService;

    public abstract T saveIt(@RequestBody Y savePojo);



}
