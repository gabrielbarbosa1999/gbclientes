package dev.gabrielbarbosa.gbclientes.repositories;

import dev.gabrielbarbosa.gbclientes.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
