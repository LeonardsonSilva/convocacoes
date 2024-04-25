package com.defensoria.convocacao.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.dtos.UnidadeRequestDTO;
import com.defensoria.convocacao.entities.Orgao;
import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.exceptions.NotFoundException;
import com.defensoria.convocacao.repositories.OrgaoRepository;
import com.defensoria.convocacao.repositories.UnidadeRepository;


@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private OrgaoRepository orgaoRepository;


    public Unidade create(UnidadeRequestDTO unidadeDTO) {

        Unidade unidade = new Unidade();
        Optional<Orgao> optionalOrgao = orgaoRepository.findById(unidadeDTO.orgaoId());

        unidade.setNome(unidadeDTO.nome());
        unidade.setOrgao(optionalOrgao.get());

        return unidadeRepository.save(unidade);
    }

    public <T> List<T> findAll(Class<T> projectionType) {
        return orgaoRepository.findAllBy(projectionType);
    }

    public Unidade findById(UUID id) {
        Optional<Unidade> instance = unidadeRepository.findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        return instance.get();
    }

    public void save(Unidade data, UUID id) {
        Optional<Unidade> instance = unidadeRepository.findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        unidadeRepository.save(data);
    }

    public void delete(UUID id) {
        unidadeRepository.deleteById(id);
    }
}
