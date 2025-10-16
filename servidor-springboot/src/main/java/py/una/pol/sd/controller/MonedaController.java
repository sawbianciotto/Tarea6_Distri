package py.una.pol.sd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.una.pol.sd.model.Moneda;
import py.una.pol.sd.service.MonedaService;

import java.util.List;
import java.util.Optional;

// Controlador para gestionar monedas
@RestController
@RequestMapping("/monedas")
public class MonedaController {

    @Autowired
    private MonedaService monedaService;

    // Lista todas las monedas
    @GetMapping("/")
    public List<Moneda> listarMonedas() {
        return monedaService.listarMonedas();
    }

    // Obtiene una moneda por su código ISO
    @GetMapping("/{codigoISO}")
    public ResponseEntity<Moneda> obtenerMonedaPorCodigoISO(@PathVariable String codigoISO) {
        Optional<Moneda> moneda = monedaService.obtenerMonedaPorCodigoISO(codigoISO);
        return moneda.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Crea una nueva moneda
    @PostMapping("/")
    public Moneda crearMoneda(@RequestBody Moneda moneda) {
        return monedaService.guardarMoneda(moneda);
    }

    // Elimina una moneda por su código ISO
    @DeleteMapping("/{codigoISO}")
    public ResponseEntity<Void> eliminarMoneda(@PathVariable String codigoISO) {
        if (monedaService.obtenerMonedaPorCodigoISO(codigoISO).isPresent()) {
            monedaService.eliminarMoneda(codigoISO);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}