package mirante.desafio.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mirante.desafio.domain.Cliente;
import mirante.desafio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/cliente",
        produces = { MediaType.APPLICATION_JSON_VALUE})
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ApiOperation(value = "Cria um novo cliente", response = Cliente.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Persistencia do objeto realizada com sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição")
    })
    public Cliente inserir(@RequestBody Cliente cliente) {
        return service.inserir(cliente);
    }

    @PutMapping
    @ApiOperation(value = "Altera um cliente", response = Cliente.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Persistencia do objeto realizada com sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição")
    })
    public Cliente alterar(@RequestBody Cliente cliente) {
        return service.alterar(cliente);
    }

    @GetMapping
    @ApiOperation(value = "Busca todos os clientes", response = Cliente[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta realizada com sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição")
    })
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca cliente por id", response = Cliente[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta realizada com sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição")
    })
    public Cliente buscarPorId(@PathVariable("id") Integer id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um cliente", response = Cliente.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Persistencia do objeto realizada com sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição")
    })
    public void deletar(@PathVariable("id") Integer id) {
        service.deletar(id);
    }
}
