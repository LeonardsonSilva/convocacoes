package com.defensoria.convocacao.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.defensoria.convocacao.dtos.UnidadeDTO;
import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.services.UnidadeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping
    public ResponseEntity<List<Unidade>> findAll() {
        List<Unidade> instances = this.unidadeService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(instances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> findById(@PathVariable(value = "id") UUID id) {
        Unidade instance = this.unidadeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(instance);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody UnidadeDTO body){
        Unidade createdEntity = unidadeService.create(body);
        String uriResource = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEntity.getId())
                .toUriString();

        return ResponseEntity.status(HttpStatus.CREATED).location(java.net.URI.create(uriResource)).build();
    }

    @PatchMapping
    public ResponseEntity<Object> save(@RequestBody Unidade entity){

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
