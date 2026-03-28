package com.dev.arg.er.agusBes7.reservation.Model.Entidad;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

//lombok me crea automaticamente  los getters y setters

@Setter
@Getter
@Entity
@Table(name="Reservaciones")
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="customer_name",length = 100,nullable = false)
    private String nombreCliente;
@Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private String servicio;
    @Column(nullable = false,length=50)
    private LocalDate fecha;
    @Column(nullable = false)
    private LocalTime hora;
    @Column(nullable = false)
    private estadoReserva estado=estadoReserva.ACTIVA;


}