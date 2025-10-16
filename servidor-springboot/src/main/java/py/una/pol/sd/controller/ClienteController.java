package py.una.pol.sd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.una.pol.sd.model.Cliente;
import py.una.pol.sd.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Lista todos los clientes
    @GetMapping("/")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    // Obtiene un cliente por su CI
    @GetMapping("/{ci}")
    public ResponseEntity<Cliente> obtenerClientePorCi(@PathVariable String ci) {
        Optional<Cliente> cliente = clienteService.obtenerClientePorCi(ci);
        return cliente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Crea un nuevo cliente
    @PostMapping("/crear/")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    // Elimina un cliente por su CI
    @DeleteMapping("/{ci}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable String ci) {
        if (clienteService.obtenerClientePorCi(ci).isPresent()) {
            clienteService.eliminarCliente(ci);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}