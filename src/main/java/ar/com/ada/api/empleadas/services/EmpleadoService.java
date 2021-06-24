package ar.com.ada.api.empleadas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.empleadas.entities.Empleado;
import ar.com.ada.api.empleadas.models.request.InfoEmpleadoNuevo;
import ar.com.ada.api.empleadas.repos.EmpleadoRepository;

@Service
public class EmpleadoService {
    
    @Autowired
    EmpleadoRepository repo;

    @Autowired
    CategoriaService categoriaService;

    public void crearEmpleado(InfoEmpleadoNuevo infoEmpleado){

        Empleado empleado = new Empleado(infoEmpleado.nombre, infoEmpleado.edad, infoEmpleado.sueldo);
        empleado.setCategoria(categoriaService.buscarCategoria(infoEmpleado.categoriaId));

        repo.save(empleado);
    }

    public List<Empleado> traerEmpleados(){

        return repo.findAll();
    }

    public Empleado traerEmpleado(Integer empleadoId){

        Optional<Empleado> resultado = repo.findById(empleadoId);

        if(resultado.isPresent())
            return resultado.get();

        return null;
    }
}
