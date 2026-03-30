package com.dev.arg.er.agusBes7.reservation.controller;

import com.dev.arg.er.agusBes7.reservation.Exceptions.ReservaExistException;
import com.dev.arg.er.agusBes7.reservation.Model.Entidad.Reservacion;
import com.dev.arg.er.agusBes7.reservation.Service.reservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gestion/reservas")
public class reservacionController {
@Autowired
private reservacionService reservacionService;
//----------------------------------------------------------

@GetMapping("")
    public List<Reservacion> listarReservas(){
    return reservacionService.findAll();}
//----------------------------------------------------------
@PostMapping("/reserva")
    public ResponseEntity<?> Reservar(@RequestBody Reservacion reservacion){
    try {
        Reservacion res = reservacionService.crearReserva(reservacion);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    } catch (ReservaExistException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
//----------------------------------------------------------
@GetMapping("/reserva/{id}")
public ResponseEntity<?> buscarReserva(@PathVariable Long id){
    try {
        Reservacion res = reservacionService.findById(id);
        return ResponseEntity.ok(res);
    } catch (ReservaExistException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

//----------------------------------------------------------
@DeleteMapping("/reserva/{id}")
public ResponseEntity<?> eliminarReserva(@PathVariable Long id){
    try {
        Reservacion res = reservacionService.cancelarReserva(id);
        return ResponseEntity.ok(res);
    } catch (ReservaExistException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
    //----------------------------------------------------------
}
