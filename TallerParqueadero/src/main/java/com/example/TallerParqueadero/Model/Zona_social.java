package com.example.TallerParqueadero.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_zona")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Zona_social {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_zona;
    private String nombre;
    private String ubicacion;
    private long capacidad;

    @OneToMany(mappedBy = "zonaSocial")
    @JsonIgnoreProperties({"zona_social", "propietario"})
    private List<Reserva_zona> reservas;
}
