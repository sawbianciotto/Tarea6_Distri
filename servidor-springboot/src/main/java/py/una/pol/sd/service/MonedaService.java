package py.una.pol.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.una.pol.sd.model.Moneda;
import py.una.pol.sd.repository.MonedaRepository;

import java.util.List;
import java.util.Optional;

// Servicio para gestionar la lógica de negocio de monedas
@Service
public class MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    // Lista todas las monedas
    public List<Moneda> listarMonedas() {
        return monedaRepository.findAll();
    }

    // Obtiene una moneda por su código ISO
    public Optional<Moneda> obtenerMonedaPorCodigoISO(String codigoISO) {
        return monedaRepository.findById(codigoISO);
    }

    // Guarda una nueva moneda
    public Moneda guardarMoneda(Moneda moneda) {
        return monedaRepository.save(moneda);
    }

    // Elimina una moneda por su código ISO
    public void eliminarMoneda(String codigoISO) {
        monedaRepository.deleteById(codigoISO);
    }
}