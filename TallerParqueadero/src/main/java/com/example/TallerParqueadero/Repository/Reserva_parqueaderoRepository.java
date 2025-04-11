package com.example.TallerParqueadero.Repository;

import com.example.TallerParqueadero.Model.Reserva_parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reserva_parqueaderoRepository extends JpaRepository<Reserva_parqueadero, Long> {

}
