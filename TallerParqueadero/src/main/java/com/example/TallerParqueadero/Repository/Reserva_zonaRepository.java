package com.example.TallerParqueadero.Repository;

import com.example.TallerParqueadero.Model.Reserva_zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reserva_zonaRepository extends JpaRepository<Reserva_zona, Long> {

}
