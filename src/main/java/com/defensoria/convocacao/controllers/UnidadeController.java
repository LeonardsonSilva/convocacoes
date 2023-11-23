package com.defensoria.convocacao.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.interfaces.CrudService;
import com.defensoria.convocacao.services.UnidadeService;

@RestController
@RequestMapping("/unidades")
public class UnidadeController extends AbstractCrudController<Unidade, UUID> {

    @Autowired
    private UnidadeService unidadeService;

    @Override
    public CrudService<Unidade, UUID> getService() {
        return this.unidadeService;
    }

}
