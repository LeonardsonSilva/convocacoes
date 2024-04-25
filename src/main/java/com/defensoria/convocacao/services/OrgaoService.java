package com.defensoria.convocacao.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Orgao;
import com.defensoria.convocacao.exceptions.NotFoundException;
import com.defensoria.convocacao.repositories.OrgaoRepository;


@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepository orgaoRepository;


    public Orgao create(Orgao orgao) {
        return orgaoRepository.save(orgao);
    }

    public List<Orgao> findAll() {
        return orgaoRepository.findAll();
    }

    public Orgao findById(UUID id) {
        Optional<Orgao> instance = orgaoRepository.findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        return instance.get();
    }

    public void save(Orgao data, UUID id) {
        Optional<Orgao> instance = orgaoRepository.findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        orgaoRepository.save(data);
    }

    public void delete(UUID id) {
        orgaoRepository.deleteById(id);
    }
}
