package mirante.desafio.repository;

import mirante.desafio.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {
}
