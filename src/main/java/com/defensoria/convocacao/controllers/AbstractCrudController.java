package com.defensoria.convocacao.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.defensoria.convocacao.interfaces.CrudController;
import com.defensoria.convocacao.interfaces.CrudService;
import com.defensoria.convocacao.interfaces.UniqueEntityId;


public abstract class AbstractCrudController<T extends UniqueEntityId, ID> implements CrudController<T, ID> {

    public abstract CrudService<T, ID> getService();

    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        List<T> instances = this.getService().findAll();

        return ResponseEntity.status(HttpStatus.OK).body(instances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable(value = "id") ID id) {
        Optional<T> instance = this.getService().findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(instance.get());
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody T data){
        T createdEntity = getService().create(data);
        String uriResource = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEntity.getId())
                .toUriString();

        return ResponseEntity.status(HttpStatus.CREATED).location(java.net.URI.create(uriResource)).build();
    }

    @PatchMapping
    public ResponseEntity<Object> save(@RequestBody T entity ){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") ID id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
