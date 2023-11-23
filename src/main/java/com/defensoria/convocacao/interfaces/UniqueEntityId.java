package com.defensoria.convocacao.interfaces;


import java.io.Serializable;
import java.util.UUID;

public interface UniqueEntityId extends Serializable {
    UUID getId();
}
