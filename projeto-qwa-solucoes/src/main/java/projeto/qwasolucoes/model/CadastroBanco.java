package projeto.qwasolucoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;


@NoArgsConstructor
@Data
@Entity
public class CadastroBanco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Nome é obrigatório. O Cliente não foi adicionado à lista")
    private String nome;

    @NotNull(message = "Sobrenome é obrigatório. O Cliente não foi adicionado à lista")
    private String sobrenome;

    @NotNull(message = "Cpf é obrigatório. O Cliente não foi adicionado à lista")
    @CPF(message = "Cpf inválido")
    @Column(unique = true)
    private String cpf;

    @Past(message = "A data deve ser passado")
    @NotNull(message = "A data de nascimento é obrigatória. O Cliente não foi adicionado à lista")
    private LocalDate dtNasc;

    private Integer idade;

    private Boolean maiorDeIdade;

    public CadastroBanco(Cadastro cadastro) {
        this.nome = cadastro.getNome();
        this.sobrenome = cadastro.getSobrenome();
        this.cpf = cadastro.getCpf();
        this.dtNasc = cadastro.getDtNasc();
        this.idade = LocalDate.now().getYear() - dtNasc.getYear();
        this.maiorDeIdade = idade >= 18;
    }

}
