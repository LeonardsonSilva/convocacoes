package com.defensoria.convocacao.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    T create(T data);

    List<T> findAll();

    Optional<T> findById(ID id);

    void save(T entity);

    void delete(ID id);
}
