package com.dev.arg.er.agusBes7.reservation.repository;

import com.dev.arg.er.agusBes7.reservation.Model.Entidad.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface reservacionRepository extends JpaRepository<Reservacion,Long> {

Optional<Reservacion>  findByFechaAndHora(LocalDate fecha, LocalTime hora);
boolean existsByFechaAndHora(LocalDate fecha, LocalTime hora);
 boolean existsById(Long id);


}
