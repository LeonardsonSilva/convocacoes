package com.defensoria.convocacao.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.repositories.UnidadeRepository;

@Service
public class FetchUnidadesUseCase {

    @Autowired
    UnidadeRepository unidadeRepository;

    public List<Unidade> execute() {
        List<Unidade> unidades = unidadeRepository.findAll();
        return unidades;
    }
}
