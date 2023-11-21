package com.defensoria.convocacao.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.repositories.UnidadeRepository;

@Service
public class CreateUnidadeUseCase {
    @Autowired
    private UnidadeRepository unidadeRepository;

    public Unidade execute(Unidade unidade) {
        return this.unidadeRepository.save(unidade);
    }
}
