package com.dev.arg.er.agusBes7.reservation.Service;

import com.dev.arg.er.agusBes7.reservation.Exceptions.ReservaExistenteException;
import com.dev.arg.er.agusBes7.reservation.Model.Entidad.Reservacion;
import com.dev.arg.er.agusBes7.reservation.repository.reservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class reservacionService {

    @Autowired
    private reservacionRepository productoRepository;

    public List<Reservacion> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Reservacion> findById(Long id) {
        return productoRepository.findById(id);
    }

    public Reservacion save(Reservacion x) {

        boolean existe = reservacionRepository
                .existsByFechaAndHora(x.getFecha(), x.getHora());

        if (existe) {
            throw new ReservaExistenteException(
                    "Ya existe una reserva para esa fecha y hora"
            );
        }

        return reservacionRepository.save(x);
    }
    public void cancelar(Long id) {

        Reservacion reserva = reservacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reservacionRepository.delete(reserva);
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}