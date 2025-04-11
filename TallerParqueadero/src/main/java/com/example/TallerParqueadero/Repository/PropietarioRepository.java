package com.example.TallerParqueadero.Repository;

import com.example.TallerParqueadero.Model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
    @Query("SELECT p FROM Propietario p JOIN FETCH p.visitantes")
    List<Propietario> findPropietariosConVisitantes();

    @Query("SELECT p FROM Propietario p JOIN FETCH p.reservasParqueadero")
    List<Propietario> findPropietariosConReservasParqueadero();

    @Query("SELECT p FROM Propietario p JOIN FETCH p.reservasZona rz JOIN FETCH rz.zonaSocial")
    List<Propietario> findPropietariosConReservasZonaSocial();

    @Query("SELECT DISTINCT p FROM Propietario p LEFT JOIN FETCH p.visitantes LEFT JOIN FETCH p.reservasParqueadero")
    List<Propietario> findPropietariosConVisitantesYParqueaderos();
}
