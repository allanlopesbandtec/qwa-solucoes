package projeto.qwasolucoes.model;


import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.*;


public class Cadastro {

    @NotNull(message = "Nome é obrigatório. O Cliente não foi adicionado à lista")
    private String nome;

    @NotNull(message = "Sobrenome é obrigatório. O Cliente não foi adicionado à lista")
    private String sobrenome;

    @NotNull(message = "Cpf é obrigatório. O Cliente não foi adicionado à lista")
    @CPF(message = "Cpf inválido")
    @Column(unique = true)
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória. O Cliente não foi adicionado à lista")
    private String dtNasc;

    public Cadastro(String nome, String sobrenome, String cpf, String dtNasc) {
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

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }
}
