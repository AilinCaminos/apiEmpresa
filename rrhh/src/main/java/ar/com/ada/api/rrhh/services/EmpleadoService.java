package ar.com.ada.api.rrhh.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.rrhh.entities.Empleado;
import ar.com.ada.api.rrhh.repos.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public void crearEmpleado(Empleado empleado){

        empleadoRepository.save(empleado);
    }

    public List<Empleado> listarEmpleados(){
        
        return empleadoRepository.findAll();
    }

    public Empleado traerEmpledoPorId(int empleadoId){ 
       
        Optional<Empleado> eo = empleadoRepository.findById(empleadoId);

        if(eo.isPresent()){
            
            return eo.get();
        }
        return null;
    }


    
}