package py.una.pol.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.pol.sd.model.Moneda;

// Repositorio para gestionar la persistencia de monedas
public interface MonedaRepository extends JpaRepository<Moneda, String> {
}