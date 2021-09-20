package projeto.qwasolucoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.qwasolucoes.model.Cadastro;
import projeto.qwasolucoes.model.CadastroBanco;
import projeto.qwasolucoes.repository.CadastroRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {

    @Autowired
    CadastroRepository cadastroRepository;

    List<CadastroBanco> cadastroDtoList = new ArrayList<>();

    Integer numeroCandidatos= 0;

    @PostMapping("/{numeroVagas}")
    public ResponseEntity<?> cadastroCandidatos(@RequestBody @Valid Cadastro cadastro,
                                                @PathVariable Integer numeroVagas) {

        numeroCandidatos = 3 * numeroVagas;

        if (cadastroDtoList.size() == numeroCandidatos){
            return ResponseEntity.badRequest().body(
                    String.format("Não é possível cadastrar mais de %d pessoas", numeroCandidatos));
        }else {

            CadastroBanco novoCadastroBanco = new CadastroBanco(cadastro);

            for (CadastroBanco cadastroBanco : cadastroDtoList){

                if (cadastroBanco.getCpf().equals(novoCadastroBanco.getCpf())) {
                    return ResponseEntity.badRequest().body("CPF já cadastrado");
                }
            }

            cadastroDtoList.add(novoCadastroBanco);
            return ResponseEntity.ok(cadastroDtoList);
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarCadastros() {

            for (CadastroBanco cadastroBanco : cadastroDtoList) {
                cadastroRepository.save(cadastroBanco);
            }

            return ResponseEntity.created(null).build();
    }

}
