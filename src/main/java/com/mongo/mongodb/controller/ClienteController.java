package com.mongo.mongodb.controller;

import com.mongo.mongodb.model.Cliente;
import com.mongo.mongodb.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarProductos() {
        return new ResponseEntity<List<Cliente>>(clienteService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearProducto(
            @RequestBody Cliente p) {
        return new ResponseEntity<>(clienteService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizarProducto(@PathVariable Long id, @RequestBody Cliente p) {
        Cliente clienteENcontrada = clienteService.findById(id);
        if (clienteENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                clienteENcontrada.setNombre(p.getNombre());
                clienteENcontrada.setApellido(p.getApellido());
                clienteENcontrada.setCedula(p.getCedula());
                clienteENcontrada.setCorreo(p.getCorreo());
                return new ResponseEntity<>(clienteService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cliente> eliminarProducto(@PathVariable Long id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
