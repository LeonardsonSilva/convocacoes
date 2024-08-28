package com.defensoria.convocacao.entities;

import java.util.UUID;

import org.hibernate.envers.Audited;

import com.defensoria.convocacao.interfaces.UniqueEntityId;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidade")
@Audited
public class Unidade implements UniqueEntityId {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    // @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "orgao_id", nullable = false)
    private Orgao orgao;

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Orgao getOrgao() {
        return this.orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

}
