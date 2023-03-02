package com.mongo.mongodb.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Restaurante")
public class Restaurante {

    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    private Carta carta;

}
