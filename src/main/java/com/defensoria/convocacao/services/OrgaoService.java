package com.defensoria.convocacao.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Orgao;
import com.defensoria.convocacao.repositories.OrgaoRepository;

@Service
public class OrgaoService extends AbstractCrudService<Orgao, UUID> {

    @Autowired
    private OrgaoRepository OrgaoRepository;

    @Override
    protected JpaRepository<Orgao, UUID> getRepository() {
        return this.OrgaoRepository;
    }
}
