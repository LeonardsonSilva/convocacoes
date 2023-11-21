package com.defensoria.convocacao.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.repositories.UnidadeRepository;

// @RequestMapping("")
@RestController
public class UnidadeController {
    @Autowired
    UnidadeRepository unidadeRepository;

    @GetMapping("/unidades")
    public ResponseEntity<List<Unidade>> getAllUnidades() {
        List<Unidade> unidades = unidadeRepository.findAll();
        if(!unidades.isEmpty()){
            for (Unidade unidade : unidades) {
                UUID id = unidade.getId();
                unidade.add(linkTo(methodOn(UnidadeController.class).getOneUnidade(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(unidades);
    }

    @GetMapping("/unidades/{id}")
    public ResponseEntity<Object> getOneUnidade(@PathVariable(value = "id") UUID id) {
        Optional<Unidade> unidade = unidadeRepository.findById(id);
        if(unidade.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade not found.");
        }

        unidade.get().add(linkTo(methodOn(UnidadeController.class).getAllUnidades()).withRel("unidades"));
        return ResponseEntity.status(HttpStatus.OK).body(unidade.get());
    }

}
