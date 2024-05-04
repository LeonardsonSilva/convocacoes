package com.defensoria.convocacao.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.defensoria.convocacao.entities.Estado;
import com.defensoria.convocacao.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController extends AbstractCrudController<Estado, UUID> {

    @Autowired
    private EstadoService estadoService;

    @Override
    public EstadoService getService() {
        return this.estadoService;
    }

}
