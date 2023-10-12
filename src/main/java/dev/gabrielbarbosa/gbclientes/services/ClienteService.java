package dev.gabrielbarbosa.gbclientes.services;

import dev.gabrielbarbosa.gbclientes.dto.ClienteDTO;
import dev.gabrielbarbosa.gbclientes.entities.Cliente;
import dev.gabrielbarbosa.gbclientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        return new ClienteDTO(cliente);
    }

}
