package projeto.qwasolucoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cadastro {

    @NotNull(message = "Nome é obrigatório. O Cliente não foi adicionado à lista")
    @Column(nullable = false)
    @NotBlank(message = "Nome é obrigatório. O Cliente não foi adicionado à lista")
    private String nome;

    @NotNull(message = "Sobrenome é obrigatório. O Cliente não foi adicionado à lista")
    @Column(nullable = false)
    @NotBlank(message = "Sobrenome é obrigatório. O Cliente não foi adicionado à lista")
    private String sobrenome;

    @NotNull(message = "Cpf é obrigatório. O Cliente não foi adicionado à lista")
    @CPF(message = "Cpf inválido")
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Cpf é obrigatório. O Cliente não foi adicionado à lista")
    private String cpf;

    @Past(message = "A data deve ser passado")
    @NotNull(message = "A data de nascimento é obrigatória. O Cliente não foi adicionado à lista")
    @Column(nullable = false)
    private LocalDate dtNasc;

}
