package com.example.TallerParqueadero.Services;

import com.example.TallerParqueadero.Model.Propietario;
import com.example.TallerParqueadero.Model.Visitante;
import com.example.TallerParqueadero.Model.Zona_social;
import com.example.TallerParqueadero.Repository.PropietarioRepository;
import com.example.TallerParqueadero.Repository.Zona_socialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Zona_socialService {
    @Autowired
    public Zona_socialRepository zona_socialRepository;

    public Zona_social buscar(long id_zona) {
        if (zona_socialRepository.existsById(id_zona)) {
            return zona_socialRepository.getById(id_zona);
        } else {
            throw new RuntimeException("Id no asignada " + id_zona);
        }
    }
    public Zona_social guardar(Zona_social zona_social){
        return zona_socialRepository.save(zona_social);
    }

    public List<Zona_social> listar(){
        return zona_socialRepository.findAll();
    }
    public void eliminar(long id_zona){
        if (zona_socialRepository.existsById(id_zona)) {
            zona_socialRepository.deleteById(id_zona);
        } else {
            throw new RuntimeException("Id no asignada " + id_zona);
        }
    }
    public Zona_social actualizar(long id_zona, Zona_social zona_social) {
        if (zona_socialRepository.existsById(id_zona)) {
            zona_social.setId_zona(id_zona);
            return zona_socialRepository.save(zona_social);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
}
