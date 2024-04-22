package com.defensoria.convocacao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defensoria.convocacao.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, UUID> {

}
