package mirante.desafio.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3)
    @Size(max = 100)
    @NotNull
    @Column(nullable = false)
    private String nome;

    @Length(min = 11, max = 11)
    @NotNull
    @Column(length = 11, nullable = false)
    private String cpf;

    private Endereco endereco;

    @ElementCollection
    @Size(min = 1)
    @Builder.Default
    private Set<Telefone> telefones = new HashSet<>();

    @ElementCollection
    @Size(min = 1)
    @Builder.Default
    private Set<String> emails = new HashSet<>();
}
