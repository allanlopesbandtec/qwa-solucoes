package projeto.qwasolucoes.model;

import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
public class CadastroBanco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Nome é obrigatório. O Candidato não foi adicionado à lista")
    private String nome;

    @NotNull(message = "Sobrenome é obrigatório. O Candidato não foi adicionado à lista")
    private String sobrenome;

    @NotNull(message = "Cpf é obrigatório. O Candidato não foi adicionado à lista")
    @CPF(message = "Cpf inválido")
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Cpf é obrigatório. O Candidato não foi adicionado à lista")
    private String cpf;

    @Past(message = "A data deve ser passado")
    @NotNull(message = "A data de nascimento é obrigatória. O Candidato não foi adicionado à lista")
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

    public CadastroBanco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtNasc() {
        DateTimeFormatter formatadorDtNasc = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatadorDtNasc.format(this.dtNasc);
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Boolean getMaiorDeIdade() {
        return maiorDeIdade;
    }

    public void setMaiorDeIdade(Boolean maiorDeIdade) {
        this.maiorDeIdade = maiorDeIdade;
    }
}

