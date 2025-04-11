package com.example.TallerParqueadero.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_visitante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Visitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_visitante;
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    @JsonIgnoreProperties({"nombre", "cedula", "fecha", "hora", "visitantes", "reservasZona", "reservasParqueadero"})
    private Propietario propietario;

}
