package com.example.TallerParqueadero.Services;

import com.example.TallerParqueadero.Model.Reserva_zona;
import com.example.TallerParqueadero.Model.Visitante;
import com.example.TallerParqueadero.Repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitanteService {
    @Autowired
    public VisitanteRepository visitanteRepository;

    public Visitante buscar(long id_visitante) {
        if (visitanteRepository.existsById(id_visitante)) {
            return visitanteRepository.getById(id_visitante);
        } else {
            throw new RuntimeException("Id no asignada " + id_visitante);
        }
    }
    public Visitante guardar(Visitante visitante){
        return visitanteRepository.save(visitante);
    }

    public List<Visitante> listar(){
        return visitanteRepository.findAll();
    }
    public void eliminar(long id_visitante){

        if (visitanteRepository.existsById(id_visitante)) {
            visitanteRepository.deleteById(id_visitante);
        } else {
            throw new RuntimeException("Id no asignada " + id_visitante);
        }
    }
    public Visitante actualizar(long id_visitante, Visitante visitante) {
        if (visitanteRepository.existsById(id_visitante)) {
            visitante.setId_visitante(id_visitante);
            return visitanteRepository.save(visitante);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
}
