package com.example.TallerParqueadero.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_propietario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_propietario;
    private String nombre;
    private String cedula;
    private LocalDate fecha;
    private LocalTime hora;

    @OneToMany(mappedBy = "propietario")
    @JsonIgnoreProperties({"nombre", "cedula", "telefono", "correo", "propietario"})
    private Set<Visitante> visitantes;

    @OneToMany(mappedBy = "propietario")
    @JsonIgnoreProperties({"zona_social", "fecha", "hora", "propietario"})
    private List<Reserva_zona> reservasZona;


    @OneToMany(mappedBy = "propietario")
    @JsonIgnoreProperties({"fecha", "hora", "propietario"})
    private Set<Reserva_parqueadero> reservasParqueadero;

}