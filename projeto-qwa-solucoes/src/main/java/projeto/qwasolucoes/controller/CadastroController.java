package projeto.qwasolucoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.qwasolucoes.model.Cadastro;
import projeto.qwasolucoes.model.CadastroBanco;
import projeto.qwasolucoes.repository.CadastroRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {

    @Autowired
    CadastroRepository cadastroRepository;

    List<CadastroBanco> cadastroDtoList = new ArrayList<>();

    Integer numeroCandidatos = 0;

    @PostMapping("/{numeroVagas}")
    public ResponseEntity<?> cadastroCandidatos(@RequestBody @Valid Cadastro cadastro,
                                                @PathVariable Integer numeroVagas) {

        numeroCandidatos = 3 * numeroVagas;

        if (cadastroDtoList.size() == numeroCandidatos){
            return ResponseEntity.status(400).body(String.format("Não é possível cadastrar mais de %d pessoas", numeroCandidatos));
        }else {
            CadastroBanco novoCadastroBanco = new CadastroBanco(cadastro);

            String validacao = cadastroRepository.procurarCpf(cadastro.getCpf());

            if (validacao == null){

                for (CadastroBanco cadastroBanco : cadastroDtoList){
                    if (cadastroBanco.getCpf().equals(novoCadastroBanco.getCpf())) {

                        System.out.println(cadastroRepository.procurarCpf(cadastro.getCpf()));

                        return ResponseEntity.badRequest().body("Cpf já cadastrado");
                    }
                }
            }else {
                return ResponseEntity.badRequest().body("Cpf já cadastrado");
            }

            cadastroDtoList.add(novoCadastroBanco);
            return ResponseEntity.created(null).body(cadastroDtoList);
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarCadastros() {

        if (cadastroDtoList.isEmpty()){
            return ResponseEntity.badRequest().body("Tabela de cadastros vazia!");
        }

        for (CadastroBanco cadastroBanco : cadastroDtoList){
            cadastroRepository.save(cadastroBanco);
        }

        cadastroDtoList.removeAll(Collections.synchronizedList(cadastroDtoList));
        return ResponseEntity.created(null).build();

    }

}
