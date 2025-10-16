package py.una.pol.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.una.pol.sd.model.Usuario;

// Repositorio para gestionar la persistencia de usuarios
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}