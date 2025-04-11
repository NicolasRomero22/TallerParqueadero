package com.example.TallerParqueadero.Services;

import com.example.TallerParqueadero.Model.Propietario;
import com.example.TallerParqueadero.Model.Reserva_parqueadero;
import com.example.TallerParqueadero.Repository.Reserva_parqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reserva_parqueaderoService {
    @Autowired
    public Reserva_parqueaderoRepository reserva_parqueaderoRepository;

    public Reserva_parqueadero buscar(long id_reserva) {
        if (reserva_parqueaderoRepository.existsById(id_reserva)) {
            return reserva_parqueaderoRepository.getById(id_reserva);
        } else {
            throw new RuntimeException("Id no asignada " + id_reserva);
        }
    }
    public Reserva_parqueadero guardar(Reserva_parqueadero reserva_parqueadero){
        return reserva_parqueaderoRepository.save(reserva_parqueadero);
    }

    public List<Reserva_parqueadero> listar(){
        return reserva_parqueaderoRepository.findAll();
    }
    public void eliminar(long id_reserva){

        if (reserva_parqueaderoRepository.existsById(id_reserva)) {
            reserva_parqueaderoRepository.deleteById(id_reserva);
        } else {
            throw new RuntimeException("Id no asignada " + id_reserva);
        }
    }

    public Reserva_parqueadero actualizar(long id_reserva, Reserva_parqueadero reserva_parqueadero) {
        if (reserva_parqueaderoRepository.existsById(id_reserva)) {
            reserva_parqueadero.setId_reserva(id_reserva);
            return reserva_parqueaderoRepository.save(reserva_parqueadero);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
}
