package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.Propietario;
import com.example.TallerParqueadero.Services.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("/listar/{id_propietario}")
    public ResponseEntity<Propietario> buscarPropietario(@PathVariable long id_propietario) {
        try {
            Propietario propietario = propietarioService.buscar(id_propietario);
            return new ResponseEntity<>(propietario, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Propietario> crearPropietario(@RequestBody Propietario propietario) {
        Propietario nuevoPropietario = propietarioService.guardar(propietario);
        return new ResponseEntity<>(nuevoPropietario, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Propietario>> listarPropietarios() {
        List<Propietario> propietarios = propietarioService.listar();
        return new ResponseEntity<>(propietarios, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_propietario}")
    public ResponseEntity<Void> eliminarPropietario(@PathVariable long id_propietario) {
        try {
            propietarioService.eliminar(id_propietario);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_propietario}")
    public ResponseEntity<Propietario> actualizarPropietario(@PathVariable long id_propietario, @RequestBody Propietario propietario) {
        try {
            Propietario propietarioActualizado = propietarioService.actualizar(id_propietario, propietario);
            return new ResponseEntity<>(propietarioActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/propietarios-con-visitantes")
    public ResponseEntity<List<Propietario>> getPropietariosConVisitantes() {
        return ResponseEntity.ok(propietarioService.obtenerPropietariosConVisitantes());
    }

    @GetMapping("/propietarios-con-parqueaderos")
    public ResponseEntity<List<Propietario>> getPropietariosConParqueaderos() {
        return ResponseEntity.ok(propietarioService.obtenerPropietariosConReservasParqueadero());
    }
    @GetMapping("/propietarios-con-zonas-sociales")
    public ResponseEntity<List<Propietario>> getPropietariosConZonasSociales() {
        return ResponseEntity.ok(propietarioService.obtenerPropietariosConZonasSociales());
    }
    @GetMapping("/propietarios-con-visitantes-parqueaderos")
    public ResponseEntity<List<Propietario>> getPropietariosConVisitantesYParqueaderos() {
        return ResponseEntity.ok(propietarioService.obtenerPropietariosConVisitantesYParqueaderos());
    }
}

