package com.defensoria.convocacao.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.repositories.UnidadeRepository;

@Service
public class UnidadeService extends AbstractCrudService<Unidade, UUID> {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Override
    protected JpaRepository<Unidade, UUID> getRepository() {
        return this.unidadeRepository;
    }
}
