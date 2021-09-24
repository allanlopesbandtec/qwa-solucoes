package projeto.qwasolucoes.model;

import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


public class Cadastro {

    @NotNull(message = "Nome é obrigatório. O Candidato não foi adicionado à lista")
    @Column(nullable = false)
    @NotBlank(message = "Nome é obrigatório. O Candidato não foi adicionado à lista")
    private String nome;

    @NotNull(message = "Sobrenome é obrigatório. O Candidato não foi adicionado à lista")
    @Column(nullable = false)
    @NotBlank(message = "Sobrenome é obrigatório. O Candidato não foi adicionado à lista")
    private String sobrenome;

    @NotNull(message = "Cpf é obrigatório. O Candidato não foi adicionado à lista")
    @CPF(message = "Cpf inválido")
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Cpf é obrigatório. O Candidato não foi adicionado à lista")
    private String cpf;

    @Past(message = "A data deve ser passado")
    @NotNull(message = "A data de nascimento é obrigatória. O Candidato não foi adicionado à lista")
    @Column(nullable = false)
    private LocalDate dtNasc;

    public Cadastro(String nome, String sobrenome, String cpf, LocalDate dtNasc) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
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
}
