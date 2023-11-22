package com.defensoria.convocacao.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.repositories.UnidadeRepository;

@Service
public class GetUnidadeUseCase {
    @Autowired
    UnidadeRepository unidadeRepository;

    public Optional<Unidade> execute(UUID id){
        Optional<Unidade> unidade = unidadeRepository.findById(id);
        return unidade;
    }
}
