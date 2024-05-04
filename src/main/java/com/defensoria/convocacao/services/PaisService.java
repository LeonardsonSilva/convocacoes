package com.defensoria.convocacao.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Pais;
import com.defensoria.convocacao.exceptions.NotFoundException;
import com.defensoria.convocacao.repositories.PaisRepository;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public Pais create(Pais pais) {
        return paisRepository.save(pais);
    }

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    public Pais findById(UUID id) {
        Optional<Pais> instance = paisRepository.findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        return instance.get();
    }

    public void save(Pais data, UUID id) {
        Optional<Pais> instance = paisRepository.findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        paisRepository.save(data);
    }

    public void delete(UUID id) {
        paisRepository.deleteById(id);
    }


}
