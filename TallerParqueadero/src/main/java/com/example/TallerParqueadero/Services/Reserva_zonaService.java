package com.example.TallerParqueadero.Services;

import com.example.TallerParqueadero.Model.Reserva_parqueadero;
import com.example.TallerParqueadero.Model.Reserva_zona;
import com.example.TallerParqueadero.Repository.Reserva_parqueaderoRepository;
import com.example.TallerParqueadero.Repository.Reserva_zonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Reserva_zonaService {
    @Autowired
    public Reserva_zonaRepository reserva_zonaRepository;

    public Reserva_zona buscar(long id_reserva) {
        if (reserva_zonaRepository.existsById(id_reserva)) {
            return reserva_zonaRepository.getById(id_reserva);
        } else {
            throw new RuntimeException("Id no asignada " + id_reserva);
        }
    }
    public Reserva_zona guardar(Reserva_zona reserva_zona){
        return reserva_zonaRepository.save(reserva_zona);
    }

    public List<Reserva_zona> listar(){
        return reserva_zonaRepository.findAll();
    }
    public void eliminar(long id_reserva){
        if (reserva_zonaRepository.existsById(id_reserva)) {
            reserva_zonaRepository.deleteById(id_reserva);
        } else {
            throw new RuntimeException("Id no asignada " + id_reserva);
        }
    }
    public Reserva_zona actualizar(long id_reserva, Reserva_zona reserva_zona) {
        if (reserva_zonaRepository.existsById(id_reserva)) {
            reserva_zona.setId_reserva(id_reserva);
            return reserva_zonaRepository.save(reserva_zona);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
}
