import React from "react";

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
    <div className="TabelaProdutos">
      <table style={{ listStyle: "none" }} border={1}>
        <thead>
          <tr>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>Cpf</th>
            <th>Data de nascimento</th>
            <th>Idade</th>
            <th>É maior de idade ?</th>
          </tr>
        </thead>
        <tbody>{getLinhas()}</tbody>
      </table>
    </div>
  );
};

export default TabelaCadastros;
