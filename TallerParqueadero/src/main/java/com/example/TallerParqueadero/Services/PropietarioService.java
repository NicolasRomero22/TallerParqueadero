package com.example.TallerParqueadero.Services;

import com.example.TallerParqueadero.Model.Propietario;
import com.example.TallerParqueadero.Repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioService {
    @Autowired
    public PropietarioRepository propietarioRepository;

    public Propietario buscar(long id_propietario) {
        if (propietarioRepository.existsById(id_propietario)) {
            return propietarioRepository.getById(id_propietario);
        } else {
            throw new RuntimeException("Id no asignada " + id_propietario);
        }
    }
    public Propietario guardar(Propietario propietario){
        return propietarioRepository.save(propietario);
    }

    public List<Propietario> listar(){
        return propietarioRepository.findAll();
    }
    public void eliminar(long id_propietario){
        if (propietarioRepository.existsById(id_propietario)) {
            propietarioRepository.deleteById(id_propietario);
        } else {
            throw new RuntimeException("Id no asignada " + id_propietario);
        }
    }
    public Propietario actualizar(long id_propietario, Propietario propietario) {
        if (propietarioRepository.existsById(id_propietario)) {
            propietario.setId_propietario(id_propietario);
            return propietarioRepository.save(propietario);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
    public List<Propietario> obtenerPropietariosConVisitantes() {
        return propietarioRepository.findPropietariosConVisitantes();
    }

    public List<Propietario> obtenerPropietariosConReservasParqueadero() {
        return propietarioRepository.findPropietariosConReservasParqueadero();
    }
    public List<Propietario> obtenerPropietariosConZonasSociales() {
        return propietarioRepository.findPropietariosConReservasZonaSocial();
    }
    public List<Propietario> obtenerPropietariosConVisitantesYParqueaderos() {
        return propietarioRepository.findPropietariosConVisitantesYParqueaderos();
    }
}
