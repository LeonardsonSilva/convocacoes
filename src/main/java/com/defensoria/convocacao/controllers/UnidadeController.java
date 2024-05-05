package com.defensoria.convocacao.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.defensoria.convocacao.dtos.OrgaoResponseDTO;
import com.defensoria.convocacao.dtos.UnidadeRequestDTO;
import com.defensoria.convocacao.dtos.UnidadeResponseDTO;
import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.services.UnidadeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @PostMapping
    public ResponseEntity<Unidade> create(@RequestBody UnidadeRequestDTO body){
        Unidade entityPersisted = unidadeService.create(body);
        String uriResource = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entityPersisted.getId())
                .toUriString();

        return ResponseEntity.status(HttpStatus.CREATED).location(java.net.URI.create(uriResource)).build();
    }

    @GetMapping
    public ResponseEntity<List<UnidadeResponseDTO>> findAll() {

        List<Unidade> entitiesFetched = this.unidadeService.findAll();
        List<UnidadeResponseDTO> unidadesResponseDTO = new ArrayList<UnidadeResponseDTO>();

        for (Unidade unidade : entitiesFetched) {
            OrgaoResponseDTO orgaoResponseDTO = new OrgaoResponseDTO(unidade.getOrgao().getNome());
            unidadesResponseDTO.add(
                new UnidadeResponseDTO(
                    unidade.getId(),
                    unidade.getNome(),
                    orgaoResponseDTO
                )
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(unidadesResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> findById(@PathVariable(value = "id") UUID id) {
        Unidade entityGetted = this.unidadeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(entityGetted);
    }

    @PatchMapping
    public ResponseEntity<Unidade> save(@RequestBody Unidade entity){

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Unidade> delete(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
