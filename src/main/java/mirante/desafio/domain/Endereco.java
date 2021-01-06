package mirante.desafio.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Embeddable
public class Endereco {

    @NotNull
    @Size(min = 8, max = 8)
    @Column(length = 8, nullable = false)
    private String cep;

    @NotNull
    @Column(nullable = false)
    private String logradouro;

    @NotNull
    @Column(nullable = false)
    private String bairro;

    @NotNull
    @Column(nullable = false)
    private String cidade;

    @NotNull
    @Size(min = 2, max = 2)
    @Column(length = 2, nullable = false)
    private String uf;

    private String complemento;
}
