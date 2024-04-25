package com.defensoria.convocacao.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.defensoria.convocacao.entities.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, UUID>  {
    @Query("SELECT u FROM Unidade u JOIN FETCH u.orgao")
    <T> List<T> findAllBy(Class<T> projectionType);
}
