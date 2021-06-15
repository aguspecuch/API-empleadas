package ar.com.ada.api.empleadas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.empleadas.entities.Empleado;
import ar.com.ada.api.empleadas.repos.EmpleadoRepository;

@Service
public class EmpleadoService {
    
    @Autowired
    EmpleadoRepository repo;

    public void crearEmpleado(Empleado empleado){

        repo.save(empleado);
    }

    public List<Empleado> traerEmpleados(){

        return repo.findAll();
    }
}
