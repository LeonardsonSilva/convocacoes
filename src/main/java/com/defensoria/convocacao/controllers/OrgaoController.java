package com.defensoria.convocacao.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.defensoria.convocacao.entities.Orgao;
import com.defensoria.convocacao.interfaces.CrudService;
import com.defensoria.convocacao.services.OrgaoService;

@RestController
@RequestMapping("/Orgaos")
public class OrgaoController extends AbstractCrudController<Orgao, UUID> {

    @Autowired
    private OrgaoService OrgaoService;

    @Override
    public CrudService<Orgao, UUID> getService() {
        return this.OrgaoService;
    }

}
