package py.una.pol.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.una.pol.sd.model.Cliente;
import py.una.pol.sd.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

// Servicio para gestionar la lógica de negocio de clientes
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Lista todos los clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Obtiene un cliente por su CI
    public Optional<Cliente> obtenerClientePorCi(String ci) {
        return clienteRepository.findById(ci);
    }

    // Guarda un nuevo cliente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Elimina un cliente por su CI
    public void eliminarCliente(String ci) {
        clienteRepository.deleteById(ci);
    }
}