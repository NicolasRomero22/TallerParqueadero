package com.example.TallerParqueadero.Model;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_reserva")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Reserva_parqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reserva;
    private LocalDate fecha;
    private LocalTime hora;


    @ManyToOne
    @JoinColumn(name = "id_propietario")
    @JsonIgnoreProperties({"nombre", "cedula", "fecha", "hora", "visitantes", "reservasZona", "reservasParqueadero"})
    private Propietario propietario;

}
