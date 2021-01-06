package mirante.desafio.service;

import mirante.desafio.domain.Cliente;
import mirante.desafio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.WebApplicationException;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente inserir(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente alterar(Cliente cliente) {
        return repository.findById(cliente.getId())
                .map(c -> repository.save(cliente))
                .orElseThrow(() -> new WebApplicationException("Registro não encontrado"));
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new WebApplicationException("Registro não encontrado"));
    }

    public void deletar(Integer id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
