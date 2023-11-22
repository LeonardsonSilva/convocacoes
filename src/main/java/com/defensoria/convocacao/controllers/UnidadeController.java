package com.defensoria.convocacao.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.defensoria.convocacao.entities.Unidade;
import com.defensoria.convocacao.repositories.UnidadeRepository;
import com.defensoria.convocacao.useCases.CreateUnidadeUseCase;
import com.defensoria.convocacao.useCases.FetchUnidadesUseCase;
import com.defensoria.convocacao.useCases.GetUnidadeUseCase;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    UnidadeRepository unidadeRepository;

    @Autowired
    private FetchUnidadesUseCase fetchUnidadesUseCase;

    @Autowired
    private GetUnidadeUseCase getUnidadeUseCase;

    @Autowired
    private CreateUnidadeUseCase createUnidadeUseCase;

    @GetMapping
    public ResponseEntity<List<Unidade>> fetchUnidades() {

        List<Unidade> unidades = this.fetchUnidadesUseCase.execute();

        if(!unidades.isEmpty()){
            for (Unidade unidade : unidades) {
                UUID id = unidade.getId();
                unidade.add(linkTo(methodOn(UnidadeController.class).getUnidade(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(unidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUnidade(@PathVariable(value = "id") UUID id) {
        Optional<Unidade> unidade = this.getUnidadeUseCase.execute(id);

        if(unidade.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade not found.");
        }
        unidade.get().add(linkTo(methodOn(UnidadeController.class).fetchUnidades()).withRel("unidades"));
        unidade.get().add(linkTo(methodOn(UnidadeController.class).getUnidade(id)).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(unidade);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Unidade unidade) {
        try {
            Unidade createdUnidade = this.createUnidadeUseCase.execute(unidade);
            String uriUnidade = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUnidade.getId())
                .toUriString();

            // ResponseEntity.status(HttpStatus.CREATED).location(java.net.URI.create(uriUnidade)).body(createdUnidade);
            return ResponseEntity.created(java.net.URI.create(uriUnidade)).build();
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

}
