package com.defensoria.convocacao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defensoria.convocacao.entities.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, UUID>  {

}
