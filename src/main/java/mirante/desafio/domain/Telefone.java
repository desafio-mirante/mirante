package mirante.desafio.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;

@Data
@Embeddable
@EqualsAndHashCode
public class Telefone {

    private String numero;

    private String tipoTelefone;
}
