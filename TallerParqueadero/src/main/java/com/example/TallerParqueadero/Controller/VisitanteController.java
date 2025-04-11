package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.Visitante;
import com.example.TallerParqueadero.Services.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitante")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping("/listar/{id_visitante}")
    public ResponseEntity<Visitante> buscarVisitante(@PathVariable long id_visitante) {
        try {
            Visitante visitante = visitanteService.buscar(id_visitante);
            return new ResponseEntity<>(visitante, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Visitante> crearVisitante(@RequestBody Visitante visitante) {
        Visitante nuevoVisitante = visitanteService.guardar(visitante);
        return new ResponseEntity<>(nuevoVisitante, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Visitante>> listarVisitantes() {
        List<Visitante> visitantes = visitanteService.listar();
        return new ResponseEntity<>(visitantes, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_visitante}")
    public ResponseEntity<Void> eliminarVisitante(@PathVariable long id_visitante) {
        try {
            visitanteService.eliminar(id_visitante);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_visitante}")
    public ResponseEntity<Visitante> actualizarVisitante(@PathVariable long id_visitante, @RequestBody Visitante visitante) {
        try {
            Visitante visitanteActualizado = visitanteService.actualizar(id_visitante, visitante);
            return new ResponseEntity<>(visitanteActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
