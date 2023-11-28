package com.defensoria.convocacao.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){
        super("Não encontrado.");
    }
}
