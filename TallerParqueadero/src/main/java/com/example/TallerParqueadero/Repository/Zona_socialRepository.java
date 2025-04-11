package com.example.TallerParqueadero.Repository;

import com.example.TallerParqueadero.Model.Zona_social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Zona_socialRepository extends JpaRepository<Zona_social, Long> {

}
