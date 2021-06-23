package ar.com.ada.api.empleadas.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.empleadas.entities.Empleado;
import ar.com.ada.api.empleadas.entities.Empleado.EstadoEmpleadoEnum;
import ar.com.ada.api.empleadas.models.request.InfoEmpleadoNuevo;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.services.*;

@RestController
public class EmpleadoController {
    
    @Autowired
    EmpleadoService service;

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/empleados")
    public ResponseEntity<?> crearEmpleado(@RequestBody InfoEmpleadoNuevo infoEmpleado){
        
        Empleado empleado = new Empleado();

        empleado.setNombre(infoEmpleado.nombre);
        empleado.setEdad(infoEmpleado.edad);
        empleado.setSueldo(infoEmpleado.sueldo);
        empleado.setEstado(EstadoEmpleadoEnum.ACTIVO);
        empleado.setFechaAlta(new Date());
        empleado.setCategoria(categoriaService.buscarCategoria(infoEmpleado.empleadaId));

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
