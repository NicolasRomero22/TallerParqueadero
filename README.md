# TallerParqueadero
Comando en postman para la obtencion de datos:

1.
GET http://localhost:8081/api/propietario/listar

RESULTADO

[
    {
        "id_propietario": 3,
        "nombre": "Juan Pérez",
        "cedula": "123456789",
        "fecha": "2025-04-10",
        "hora": "08:30:00",
        "visitantes": [
            {
                "id_visitante": 3
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 2,
                "zonaSocial": {
                    "id_zona": 2,
                    "ubicacion": "Zona Recreativa"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 3
            }
        ]
    },
    {
        "id_propietario": 4,
        "nombre": "Ana Castañeda",
        "cedula": "123456789",
        "fecha": "2024-06-10",
        "hora": "12:30:00",
        "visitantes": [
            {
                "id_visitante": 4
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 3,
                "zonaSocial": {
                    "id_zona": 3,
                    "ubicacion": "Segundo Piso"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 4
            }
        ]
    },
    {
        "id_propietario": 5,
        "nombre": "Michael Jackson",
        "cedula": "666666666",
        "fecha": "2022-06-06",
        "hora": "11:11:00",
        "visitantes": [
            {
                "id_visitante": 5
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 4,
                "zonaSocial": {
                    "id_zona": 4,
                    "ubicacion": "Azotea"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 5
            }
        ]
    },
    {
        "id_propietario": 1,
        "nombre": "Jhon",
        "cedula": "12423423",
        "fecha": "2024-03-02",
        "hora": "05:30:00",
        "visitantes": [
            {
                "id_visitante": 1
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 5,
                "zonaSocial": {
                    "id_zona": 5,
                    "ubicacion": "Sótano"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 1
            }
        ]
    },
    {
        "id_propietario": 2,
        "nombre": "Jhon Jairo",
        "cedula": "1000234654",
        "fecha": "2025-04-08",
        "hora": "10:00:00",
        "visitantes": [
            {
                "id_visitante": 2
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 1,
                "zonaSocial": {
                    "id_zona": 1,
                    "ubicacion": "Bloque A"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 2
            }
        ]
    }
]
CONSULTAS:

MOSTRAR PROPIETARIOS CON VISITANTES
MOSTRAR PROPIETARIOS CON PARQUEADEROS
MOSTRAR PROPIETARIOS CON RESERVA SOCIAL
MOSTRAR PROPITARIO CON VISITANTES Y PARQUEADERO

Código Repository:

    @Query("SELECT p FROM Propietario p JOIN FETCH p.visitantes")
    List<Propietario> findPropietariosConVisitantes();

    @Query("SELECT p FROM Propietario p JOIN FETCH p.reservasParqueadero")
    List<Propietario> findPropietariosConReservasParqueadero();

    @Query("SELECT p FROM Propietario p JOIN FETCH p.reservasZona rz JOIN FETCH rz.zonaSocial")
    List<Propietario> findPropietariosConReservasZonaSocial();

    @Query("SELECT DISTINCT p FROM Propietario p LEFT JOIN FETCH p.visitantes LEFT JOIN FETCH p.reservasParqueadero")
    List<Propietario> findPropietariosConVisitantesYParqueaderos();

Código Service:

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

Código Controller:

@GetMapping("/propietarios-con-visitantes")
    public ResponseEntity<List<Propietario>> getPropietariosConVisitantes() {
        return ResponseEntity.ok(propietarioService.obtenerPropietariosConVisitantes());
    }

    @GetMapping("/propietarios-con-parqueaderos")
    public ResponseEntity<List<Propietario>> getPropietariosConParqueaderos() {
        return ResponseEntity.ok(propietarioService.obtenerPropietariosConReservasParqueadero());
    }
    @GetMapping("/propietarios-con-zonas-sociales")
    public ResponseEntity<List<Propietario>> getPropietariosConZonasSociales() {
        return ResponseEntity.ok(propietarioService.obtenerPropietariosConZonasSociales());
    }
    @GetMapping("/propietarios-con-visitantes-parqueaderos")
    public ResponseEntity<List<Propietario>> getPropietariosConVisitantesYParqueaderos() {
        return ResponseEntity.ok(propietarioService.obtenerPropietariosConVisitantesYParqueaderos());
    }

RESULTADOS:
MOSTRAR PROPIETARIOS CON VISITANTES
[
    {
        "id_propietario": 3,
        "nombre": "Juan Pérez",
        "cedula": "123456789",
        "fecha": "2025-04-10",
        "hora": "08:30:00",
        "visitantes": [
            {
                "id_visitante": 3
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 2,
                "zonaSocial": {
                    "id_zona": 2,
                    "ubicacion": "Zona Recreativa"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 3
            }
        ]
    },
    {
        "id_propietario": 4,
        "nombre": "Ana Castañeda",
        "cedula": "123456789",
        "fecha": "2024-06-10",
        "hora": "12:30:00",
        "visitantes": [
            {
                "id_visitante": 4
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 3,
                "zonaSocial": {
                    "id_zona": 3,
                    "ubicacion": "Segundo Piso"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 4
            }
        ]
    },
    {
        "id_propietario": 5,
        "nombre": "Michael Jackson",
        "cedula": "666666666",
        "fecha": "2022-06-06",
        "hora": "11:11:00",
        "visitantes": [
            {
                "id_visitante": 5
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 4,
                "zonaSocial": {
                    "id_zona": 4,
                    "ubicacion": "Azotea"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 5
            }
        ]
    },
    {
        "id_propietario": 1,
        "nombre": "Jhon",
        "cedula": "12423423",
        "fecha": "2024-03-02",
        "hora": "05:30:00",
        "visitantes": [
            {
                "id_visitante": 1
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 5,
                "zonaSocial": {
                    "id_zona": 5,
                    "ubicacion": "Sótano"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 1
            }
        ]
    },
    {
        "id_propietario": 2,
        "nombre": "Jhon Jairo",
        "cedula": "1000234654",
        "fecha": "2025-04-08",
        "hora": "10:00:00",
        "visitantes": [
            {
                "id_visitante": 2
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 1,
                "zonaSocial": {
                    "id_zona": 1,
                    "ubicacion": "Bloque A"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 2
            }
        ]
    }
]

MOSTRAR PROPIETARIOS CON PARQUEADEROS

[
    {
        "id_propietario": 1,
        "nombre": "Jhon",
        "cedula": "12423423",
        "fecha": "2024-03-02",
        "hora": "05:30:00",
        "visitantes": [
            {
                "id_visitante": 1
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 5,
                "zonaSocial": {
                    "id_zona": 5,
                    "ubicacion": "Sótano"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 1
            }
        ]
    },
    {
        "id_propietario": 2,
        "nombre": "Jhon Jairo",
        "cedula": "1000234654",
        "fecha": "2025-04-08",
        "hora": "10:00:00",
        "visitantes": [
            {
                "id_visitante": 2
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 1,
                "zonaSocial": {
                    "id_zona": 1,
                    "ubicacion": "Bloque A"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 2
            }
        ]
    },
    {
        "id_propietario": 3,
        "nombre": "Juan Pérez",
        "cedula": "123456789",
        "fecha": "2025-04-10",
        "hora": "08:30:00",
        "visitantes": [
            {
                "id_visitante": 3
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 2,
                "zonaSocial": {
                    "id_zona": 2,
                    "ubicacion": "Zona Recreativa"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 3
            }
        ]
    },
    {
        "id_propietario": 4,
        "nombre": "Ana Castañeda",
        "cedula": "123456789",
        "fecha": "2024-06-10",
        "hora": "12:30:00",
        "visitantes": [
            {
                "id_visitante": 4
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 3,
                "zonaSocial": {
                    "id_zona": 3,
                    "ubicacion": "Segundo Piso"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 4
            }
        ]
    },
    {
        "id_propietario": 5,
        "nombre": "Michael Jackson",
        "cedula": "666666666",
        "fecha": "2022-06-06",
        "hora": "11:11:00",
        "visitantes": [
            {
                "id_visitante": 5
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 4,
                "zonaSocial": {
                    "id_zona": 4,
                    "ubicacion": "Azotea"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 5
            }
        ]
    }
]

PROPIETARIOS CON ZONAS SOCIALES

[
    {
        "id_propietario": 4,
        "nombre": "Ana Castañeda",
        "cedula": "123456789",
        "fecha": "2024-06-10",
        "hora": "12:30:00",
        "visitantes": [
            {
                "id_visitante": 4
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 3,
                "zonaSocial": {
                    "id_zona": 3,
                    "ubicacion": "Segundo Piso"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 4
            }
        ]
    },
    {
        "id_propietario": 3,
        "nombre": "Juan Pérez",
        "cedula": "123456789",
        "fecha": "2025-04-10",
        "hora": "08:30:00",
        "visitantes": [
            {
                "id_visitante": 3
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 2,
                "zonaSocial": {
                    "id_zona": 2,
                    "ubicacion": "Zona Recreativa"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 3
            }
        ]
    },
    {
        "id_propietario": 2,
        "nombre": "Jhon Jairo",
        "cedula": "1000234654",
        "fecha": "2025-04-08",
        "hora": "10:00:00",
        "visitantes": [
            {
                "id_visitante": 2
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 1,
                "zonaSocial": {
                    "id_zona": 1,
                    "ubicacion": "Bloque A"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 2
            }
        ]
    },
    {
        "id_propietario": 5,
        "nombre": "Michael Jackson",
        "cedula": "666666666",
        "fecha": "2022-06-06",
        "hora": "11:11:00",
        "visitantes": [
            {
                "id_visitante": 5
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 4,
                "zonaSocial": {
                    "id_zona": 4,
                    "ubicacion": "Azotea"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 5
            }
        ]
    },
    {
        "id_propietario": 1,
        "nombre": "Jhon",
        "cedula": "12423423",
        "fecha": "2024-03-02",
        "hora": "05:30:00",
        "visitantes": [
            {
                "id_visitante": 1
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 5,
                "zonaSocial": {
                    "id_zona": 5,
                    "ubicacion": "Sótano"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 1
            }
        ]
    }
]
MOSTRAR PROPITARIO CON VISITANTES Y PARQUEADERO

[
    {
        "id_propietario": 1,
        "nombre": "Jhon",
        "cedula": "12423423",
        "fecha": "2024-03-02",
        "hora": "05:30:00",
        "visitantes": [
            {
                "id_visitante": 1
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 5,
                "zonaSocial": {
                    "id_zona": 5,
                    "ubicacion": "Sótano"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 1
            }
        ]
    },
    {
        "id_propietario": 2,
        "nombre": "Jhon Jairo",
        "cedula": "1000234654",
        "fecha": "2025-04-08",
        "hora": "10:00:00",
        "visitantes": [
            {
                "id_visitante": 2
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 1,
                "zonaSocial": {
                    "id_zona": 1,
                    "ubicacion": "Bloque A"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 2
            }
        ]
    },
    {
        "id_propietario": 3,
        "nombre": "Juan Pérez",
        "cedula": "123456789",
        "fecha": "2025-04-10",
        "hora": "08:30:00",
        "visitantes": [
            {
                "id_visitante": 3
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 2,
                "zonaSocial": {
                    "id_zona": 2,
                    "ubicacion": "Zona Recreativa"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 3
            }
        ]
    },
    {
        "id_propietario": 4,
        "nombre": "Ana Castañeda",
        "cedula": "123456789",
        "fecha": "2024-06-10",
        "hora": "12:30:00",
        "visitantes": [
            {
                "id_visitante": 4
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 3,
                "zonaSocial": {
                    "id_zona": 3,
                    "ubicacion": "Segundo Piso"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 4
            }
        ]
    },
    {
        "id_propietario": 5,
        "nombre": "Michael Jackson",
        "cedula": "666666666",
        "fecha": "2022-06-06",
        "hora": "11:11:00",
        "visitantes": [
            {
                "id_visitante": 5
            }
        ],
        "reservasZona": [
            {
                "id_reserva": 4,
                "zonaSocial": {
                    "id_zona": 4,
                    "ubicacion": "Azotea"
                }
            }
        ],
        "reservasParqueadero": [
            {
                "id_reserva": 5
            }
        ]
    }
]
