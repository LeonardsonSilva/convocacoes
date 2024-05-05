package com.defensoria.convocacao.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.defensoria.convocacao.entities.Estado;
import com.defensoria.convocacao.services.EstadoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Estado body){
        Estado entityPersisted = estadoService.create(body);
        String uriResource = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entityPersisted.getId())
                .toUriString();

        return ResponseEntity.status(HttpStatus.CREATED).location(java.net.URI.create(uriResource)).build();
    }

    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        List<Estado> entitiesFetched = this.estadoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(entitiesFetched);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(@PathVariable(value = "id") UUID id) {
        Estado entityGetted = this.estadoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(entityGetted);
    }

    @PatchMapping
    public ResponseEntity<Object> save(@RequestBody Estado entity){

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
