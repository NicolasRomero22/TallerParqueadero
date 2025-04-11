package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.Zona_social;
import com.example.TallerParqueadero.Services.Zona_socialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zona_social")
public class Zona_socialController {

    @Autowired
    private Zona_socialService zona_socialService;

    @GetMapping("/listar/{id_zona}")
    public ResponseEntity<Zona_social> buscarZonaSocial(@PathVariable long id_zona) {
        try {
            Zona_social zona = zona_socialService.buscar(id_zona);
            return new ResponseEntity<>(zona, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Zona_social> crearZonaSocial(@RequestBody Zona_social zona_social) {
        Zona_social nuevaZonaSocial = zona_socialService.guardar(zona_social);
        return new ResponseEntity<>(nuevaZonaSocial, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Zona_social>> listarZonasSociales() {
        List<Zona_social> zonas = zona_socialService.listar();
        return new ResponseEntity<>(zonas, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_zona}")
    public ResponseEntity<Void> eliminarZonaSocial(@PathVariable long id_zona) {
        try {
            zona_socialService.eliminar(id_zona);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_zona}")
    public ResponseEntity<Zona_social> actualizarZonaSocial(@PathVariable long id_zona, @RequestBody Zona_social zona_social) {
        try {
            Zona_social zonaActualizada = zona_socialService.actualizar(id_zona, zona_social);
            return new ResponseEntity<>(zonaActualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

