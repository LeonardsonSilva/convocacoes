package com.defensoria.convocacao.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.defensoria.convocacao.entities.Pais;
import com.defensoria.convocacao.services.PaisService;

@RestController
@RequestMapping("/paises")
public class PaisController extends AbstractCrudController<Pais, UUID> {

    @Autowired
    private PaisService PaisService;

    @Override
    public PaisService getService() {
        return this.PaisService;
    }
}
