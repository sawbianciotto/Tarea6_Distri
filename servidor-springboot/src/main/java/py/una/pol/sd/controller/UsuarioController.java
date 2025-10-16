package py.una.pol.sd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.una.pol.sd.model.Usuario;
import py.una.pol.sd.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Controlador para gestionar usuarios
    @GetMapping("/")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // Obtiene un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Crea un nuevo usuario
    @PostMapping("/")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCreado = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.status(201).body(usuarioCreado);
    }

    // Edita un usuario existente por su ID
    @PutMapping("/{id}/editar/")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuarioService.obtenerUsuarioPorId(id).isPresent()) {
            usuario.setId(id);
            return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Elimina un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        if (usuarioService.obtenerUsuarioPorId(id).isPresent()) {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}