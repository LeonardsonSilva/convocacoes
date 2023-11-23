package com.defensoria.convocacao.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CrudController<T extends UniqueEntityId, ID> {
    ResponseEntity<List<T>> findAll();
    ResponseEntity<T> findById(ID id);
    ResponseEntity<Object> create(T data);
    ResponseEntity<Object> save(T entity);
    ResponseEntity<Object> delete(ID id);
}
