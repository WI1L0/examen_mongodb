package com.mongo.mongodb.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Carta")
public class Carta {

    private String nombre;
    private String categoria;
    private Integer cantidad;

    private Plato plato;

}
