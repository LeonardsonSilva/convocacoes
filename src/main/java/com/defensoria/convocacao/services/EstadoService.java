package com.defensoria.convocacao.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defensoria.convocacao.entities.Estado;
import com.defensoria.convocacao.exceptions.NotFoundException;
import com.defensoria.convocacao.repositories.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado create(Estado estado) {
        return estadoRepository.save(estado);
    }

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado findById(UUID id) {
        Optional<Estado> instance = estadoRepository.findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        return instance.get();
    }

    public void save(Estado data, UUID id) {
        Optional<Estado> instance = estadoRepository.findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        estadoRepository.save(data);
    }

    public void delete(UUID id) {
        estadoRepository.deleteById(id);
    }


}
