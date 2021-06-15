package ar.com.ada.api.empleadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.empleadas.entities.Empleado;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.services.EmpleadoService;

@RestController
public class EmpleadoController {
    
    @Autowired
    EmpleadoService service;

    @PostMapping("/empleados")
    public ResponseEntity<?> crearEmpleado(Empleado empleado){
        
        service.crearEmpleado(empleado);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.id = empleado.getEmpleadoId();
        r.message = "Empleado creado con exito.";

        return ResponseEntity.ok(r);
    }

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> traerEmpleados(){
        
        return ResponseEntity.ok(service.traerEmpleados());
    }
    
}
