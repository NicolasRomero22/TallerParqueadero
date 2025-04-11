package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.Reserva_zona;
import com.example.TallerParqueadero.Services.Reserva_zonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva_zona")
public class Reserva_zonaController {

    @Autowired
    private Reserva_zonaService reserva_zonaService;

    @GetMapping("/listar/{id_reserva}")
    public ResponseEntity<Reserva_zona> buscarReservaZona(@PathVariable long id_reserva) {
        try {
            Reserva_zona reservaZona = reserva_zonaService.buscar(id_reserva);
            return new ResponseEntity<>(reservaZona, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Reserva_zona> crearReservaZona(@RequestBody Reserva_zona reserva_zona) {
        Reserva_zona nuevaReservaZona = reserva_zonaService.guardar(reserva_zona);
        return new ResponseEntity<>(nuevaReservaZona, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Reserva_zona>> listarReservasZona() {
        List<Reserva_zona> reservasZona = reserva_zonaService.listar();
        return new ResponseEntity<>(reservasZona, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_reserva}")
    public ResponseEntity<Void> eliminarReservaZona(@PathVariable long id_reserva) {
        try {
            reserva_zonaService.eliminar(id_reserva);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_reserva}")
    public ResponseEntity<Reserva_zona> actualizarReservaZona(@PathVariable long id_reserva, @RequestBody Reserva_zona reserva_zona) {
        try {
            Reserva_zona reservaZonaActualizada = reserva_zonaService.actualizar(id_reserva, reserva_zona);
            return new ResponseEntity<>(reservaZonaActualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

