package com.mongo.mongodb.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Plato")
public class Plato {

    private String nombrePlato;
    private String descripcion;
    private Double precio;

}
