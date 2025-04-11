package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.Reserva_parqueadero;
import com.example.TallerParqueadero.Services.Reserva_parqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva_parqueadero")
public class Reserva_parqueaderoController {

    @Autowired
    private Reserva_parqueaderoService reserva_parqueaderoService;

    @GetMapping("/listar/{id_reserva}")
    public ResponseEntity<Reserva_parqueadero> buscarReserva(@PathVariable long id_reserva) {
        try {
            Reserva_parqueadero reserva = reserva_parqueaderoService.buscar(id_reserva);
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Reserva_parqueadero> crearReserva(@RequestBody Reserva_parqueadero reserva_parqueadero) {
        Reserva_parqueadero nuevaReserva = reserva_parqueaderoService.guardar(reserva_parqueadero);
        return new ResponseEntity<>(nuevaReserva, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Reserva_parqueadero>> listarReservas() {
        List<Reserva_parqueadero> reservas = reserva_parqueaderoService.listar();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_reserva}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable long id_reserva) {
        try {
            reserva_parqueaderoService.eliminar(id_reserva);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_reserva}")
    public ResponseEntity<Reserva_parqueadero> actualizarReserva(@PathVariable long id_reserva, @RequestBody Reserva_parqueadero reserva_parqueadero) {
        try {
            Reserva_parqueadero reservaActualizada = reserva_parqueaderoService.actualizar(id_reserva, reserva_parqueadero);
            return new ResponseEntity<>(reservaActualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

