package ar.com.ada.api.empleadas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.empleadas.entities.*;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.services.*;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @PostMapping("/clientes")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){
        
        service.crearCategoria(categoria);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.id = categoria.getCategoriaId();
        r.message = "Categoria creada con exito.";

        return ResponseEntity.ok(r);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Categoria>> traerCategorias(){

        return ResponseEntity.ok(service.traerCategorias());
    }
}
