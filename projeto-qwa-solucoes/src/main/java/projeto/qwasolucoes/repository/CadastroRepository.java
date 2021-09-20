package projeto.qwasolucoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.qwasolucoes.model.CadastroBanco;


public interface CadastroRepository extends JpaRepository<CadastroBanco, Integer> {


}
