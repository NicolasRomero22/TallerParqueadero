package com.example.TallerParqueadero.Repository;

import com.example.TallerParqueadero.Model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

}
