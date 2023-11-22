package com.defensoria.convocacao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defensoria.convocacao.entities.Orgao;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, UUID>{

}
