package py.una.pol.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.pol.sd.model.Cliente;

// Repositorio para gestionar la persistencia de clientes
public interface ClienteRepository extends JpaRepository<Cliente, String> {
}