package com.defensoria.convocacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.defensoria.convocacao.entities.Orgao;
import com.defensoria.convocacao.repositories.OrgaoRepository;

@RestController
@RequestMapping("/orgaos")
public class OrgaoController {

    @Autowired
    private OrgaoRepository orgaoRepository;

    @GetMapping
    public ResponseEntity<List<Orgao>> fetchOrgao(){
        List<Orgao> orgaos = this.orgaoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(orgaos);
    }

}
