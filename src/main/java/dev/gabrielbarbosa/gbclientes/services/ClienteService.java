package dev.gabrielbarbosa.gbclientes.services;

import dev.gabrielbarbosa.gbclientes.dto.ClienteDTO;
import dev.gabrielbarbosa.gbclientes.entities.Cliente;
import dev.gabrielbarbosa.gbclientes.repositories.ClienteRepository;
import dev.gabrielbarbosa.gbclientes.services.exceptions.NotFoundClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteService {

    private final String CLIENTE_NOT_FOUND = "CLIENTE NÃO ENCONTRADO.";

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable).map(ClienteDTO::new);
    }

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new NotFoundClientException(CLIENTE_NOT_FOUND));
        return new ClienteDTO(cliente);
    }

    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }

}
