package com.defensoria.convocacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.defensoria.convocacao.exceptions.NotFoundException;
import com.defensoria.convocacao.interfaces.CrudService;


public abstract class AbstractCrudService<T, ID> implements CrudService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public T create(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) {
        Optional<T> instance = getRepository().findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        return instance.get();
    }

    @Override
    public void save(T data, ID id) {
        Optional<T> instance = getRepository().findById(id);
        if (instance.isEmpty()) {
            throw new NotFoundException();
        }
        getRepository().save(data);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

}
