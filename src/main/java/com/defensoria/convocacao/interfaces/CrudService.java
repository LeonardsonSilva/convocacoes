package com.defensoria.convocacao.interfaces;

import java.util.List;

public interface CrudService<T, ID> {
    T create(T data);

    List<T> findAll();

    T findById(ID id);

    void save(T entity, ID id);

    void delete(ID id);
}
