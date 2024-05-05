package com.defensoria.convocacao.dtos;

import java.util.UUID;

public record UnidadeResponseDTO(UUID id, String nome, OrgaoResponseDTO orgao) {
}
