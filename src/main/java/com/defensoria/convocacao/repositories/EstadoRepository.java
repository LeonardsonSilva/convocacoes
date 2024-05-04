package com.defensoria.convocacao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defensoria.convocacao.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, UUID>  {

}
