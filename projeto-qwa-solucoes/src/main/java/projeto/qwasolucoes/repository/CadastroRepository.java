package projeto.qwasolucoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projeto.qwasolucoes.model.CadastroBanco;


public interface CadastroRepository extends JpaRepository<CadastroBanco, Integer> {

    @Query("select c.cpf from CadastroBanco c where c.cpf = ?1")
    String procurarCpf(String cpf);

}
