import React from "react";
import '../../assets/css/tabela.css'

function TabelaCadastros(props) {

  const cadastros = props.obj;

  function getLinhas() {
    return cadastros.map((cadastro) => {
      return (


        //className={i % 2 === 0 ? "Par" : "Impar"}
        <tr key={cadastro.cpf} >
          <td>{cadastro.nome}</td>
          <td>{cadastro.sobrenome}</td>
          <td>{cadastro.cpf}</td>
          <td>{cadastro.dtNasc}</td>
          <td>{cadastro.idade}</td>
          <td>{cadastro.maiorDeIdade ? 'Sim' : 'Não'}</td>
        </tr>
      );
    });
  }

  return (
      <table>
        <thead>
          <tr className="titulo">
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>CPF</th>
            <th>Nascimento</th>
            <th>Idade</th>
            <th>Maior de idade</th>
          </tr>
        </thead>
        <tbody>{getLinhas()}</tbody>
      </table>
  );
};

export default TabelaCadastros;
