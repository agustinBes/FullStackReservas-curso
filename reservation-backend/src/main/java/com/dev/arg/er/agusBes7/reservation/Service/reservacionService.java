package com.dev.arg.er.agusBes7.reservation.Service;


import com.dev.arg.er.agusBes7.reservation.Exceptions.ReservaExistException;
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

    public Reservacion findById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ReservaExistException("No existe una reserva con el id recibido"));
    }
    //---------------------------------------
    public Reservacion cancelarReserva(Long id) {
        Reservacion res=this.findById(id);
        productoRepository.delete(res);
return res;}
    //---------------------------------------
    public Reservacion crearReserva(Reservacion reservacion) {
        if (productoRepository.existsByFechaAndHora(
                reservacion.getFecha(), reservacion.getHora())) {

            throw new ReservaExistException("Ya existe una reserva en esa fecha y hora");
        }

        productoRepository.save(reservacion);
    return reservacion;}




}

