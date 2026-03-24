package com.dev.arg.er.agusBes7.reservation.repository;

import com.dev.arg.er.agusBes7.reservation.Model.Entidad.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface reservacionRepository extends JpaRepository<Reservacion,Long> {
    static boolean existsByFechaAndHora(LocalDate fecha, LocalTime hora) {
    }

    boolean existsByDateAndTime(LocalDate date, LocalTime time);
boolean existsById(Long id);

}
