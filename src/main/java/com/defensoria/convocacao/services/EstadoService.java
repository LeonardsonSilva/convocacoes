package com.defensoria.convocacao.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Estado;
import com.defensoria.convocacao.repositories.EstadoRepository;

@Service
public class EstadoService extends AbstractCrudService<Estado, UUID> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    protected EstadoRepository getRepository() {
        return this.estadoRepository;
    }
}
