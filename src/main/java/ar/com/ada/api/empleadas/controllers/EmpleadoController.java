package ar.com.ada.api.empleadas.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.empleadas.entities.Empleado;
import ar.com.ada.api.empleadas.models.request.InfoEmpleadoNuevo;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.services.*;

@RestController
public class EmpleadoController {
    
    @Autowired
    EmpleadoService service;

    @PostMapping("/empleados")
    public ResponseEntity<?> altaEmpleado(@RequestBody InfoEmpleadoNuevo infoEmpleado){
        
        Empleado e = service.altaEmpleado(infoEmpleado);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.id = e.getEmpleadoId();
        r.message = "Empleado creado con exito.";

        return ResponseEntity.ok(r);
    }

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> traerEmpleados(){
        
        return ResponseEntity.ok(service.traerEmpleados());
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> traerEmpleado(@PathVariable Integer id){

        return ResponseEntity.ok(service.traerEmpleado(id));
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<GenericResponse> bajaEmpleado(@PathVariable Integer id){

        Empleado e = service.bajaEmpleado(id);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.id = e.getEmpleadoId();
        r.message = "Empleado dado de baja con exito";

        return ResponseEntity.ok(r);
    }

    @GetMapping("/empleados/categorias/{id}")
    public ResponseEntity<List<Empleado>> traerEmpleadosByCategoria(@PathVariable Integer id){

        return ResponseEntity.ok(service.traerEmpleadosByCategoria(id));
    }
    
}
