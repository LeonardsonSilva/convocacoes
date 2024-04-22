package com.defensoria.convocacao.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Pais;
import com.defensoria.convocacao.repositories.PaisRepository;

@Service
public class PaisService extends AbstractCrudService<Pais, UUID> {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    protected PaisRepository getRepository() {
        return this.paisRepository;
    }
}
