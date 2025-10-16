package py.una.pol.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.una.pol.sd.model.Usuario;
import py.una.pol.sd.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

// Servicio para gestionar la lógica de negocio de usuarios
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Lista todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtiene un usuario por su ID
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guarda un nuevo usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Elimina un usuario por su ID
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}