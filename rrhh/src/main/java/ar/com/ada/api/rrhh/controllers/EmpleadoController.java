package ar.com.ada.api.rrhh.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.rrhh.entities.Empleado;
import ar.com.ada.api.rrhh.models.requests.InfoBasicaEmpleadoRequest;
import ar.com.ada.api.rrhh.services.CategoriaService;
import ar.com.ada.api.rrhh.services.EmpleadoService;

@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/empleados")
    public ResponseEntity<?> crearEmpleado(@RequestBody InfoBasicaEmpleadoRequest info){
        
        Empleado empleado = new Empleado();
        empleado.setNombre(info.nombre);
        empleado.setEdad(info.edad);
        empleado.setSueldo(info.sueldo);
        empleado.setCategoria(categoriaService.buscarCategoriaPorId(info.categoriaId));
        empleado.setFechaAlta(new Date());
        empleado.setEmpleadoId(1);
        empleadoService.crearEmpleado(empleado);
        

        return ResponseEntity.ok(empleado.getEmpleadoId());

    }
    @GetMapping("/empleados")
    public ResponseEntity<?> listarEmpleado(){

        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }
    
}