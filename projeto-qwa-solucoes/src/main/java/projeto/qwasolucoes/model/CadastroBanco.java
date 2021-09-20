package projeto.qwasolucoes.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    @NotNull(message = "A data de nascimento é obrigatória. O Cliente não foi adicionado à lista")
    private LocalDate dtNasc;

    private Integer idade;

    private Boolean maiorDeIdade;

    public CadastroBanco(Cadastro cadastro) {
        this.nome = cadastro.getNome();
        this.sobrenome = cadastro.getSobrenome();
        this.cpf = cadastro.getCpf();
        this.dtNasc = LocalDate.parse(cadastro.getDtNasc());
        this.idade = LocalDate.now().getYear() - dtNasc.getYear();
        this.maiorDeIdade = idade >= 18;
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

    public LocalDate getDtNasc() {
        return dtNasc;
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
