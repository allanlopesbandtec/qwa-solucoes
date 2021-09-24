import React, {useState} from 'react'
import axios from 'axios'
import TabelaCadastros from './tabela/TabelaCadastros';
import '../assets/css/vagas.css'



function Vagas(){

    const [cadastroList, setCadastroList] = useState([]);

    const [numeroVagas, setNumeroVagas] = useState(0);

    const [cadastro, setCadastro] = useState({});

    const handleChangeCadastro = (event) => {
        const value = { ...cadastro }
        value[event.target.name] = event.target.value;
        setCadastro(value)
    };

    const handleChangeVagas = (event) => {
        const value = { ...numeroVagas }
        value[event.target.name] = event.target.value;
        setNumeroVagas(value.numeroVagas)
    };

    const handleSubmit = event => {
       cadastrar();
       event.preventDefault();
    };

    function cadastrar() {

           axios.post(`http://localhost:8080/cadastros/${numeroVagas}`, cadastro)
            .then((resposta) => {

                if(resposta.status === 201){
                    alert("Adicionado com sucesso!")
                    setCadastroList(resposta.data)
                } 
            }).catch((error) => {

                var x = error.response.data;

                if(typeof x == 'string'){
                    alert(x)
                } else{
                    alert(x.errors[0].defaultMessage)
                }
                
            })
    }
    
    function salvarTodos(){
          axios.post(`http://localhost:8080/cadastros/salvar`)
            .then((resposta) => {

                if(resposta.status === 201){
                    alert("Candidatos cadastrados com sucesso")
                     window.location.reload();
                } 
            }).catch((error) => {

                var x = error.response.data;

                if(typeof x == 'string'){
                    alert(x)
                } else{
                    alert(x.errors[0].defaultMessage)
                }  
            })
    }

    return (
        <>

        

        <header>
            <div className="botao-header">
             <button onClick={salvarTodos}>Salvar Cadastros</button>
            </div>
        </header>

        <div className="conteudo">

         <div className="campo-vagas">
        <label htmlFor="numeroVagas">Número de vagas: </label>
        <input type="text"
        id="numeroVagas"
        name="numeroVagas" onChange={handleChangeVagas}/> 
       </div>

            <form onSubmit={handleSubmit}>

                <h3>Cadastro de candidato</h3>

                <div className="campo-form">          
                <label htmlFor="nome">Nome: </label>
                <input type="text"
                id="nome"
                name="nome" onChange={handleChangeCadastro}/>
                </div>

                <div className="campo-form">
                <label htmlFor="sobrenome">Sobrenome: </label>
                <input type="text"
                id="sobrenome"
                name="sobrenome" onChange={handleChangeCadastro}/>
                </div>

                <div className="campo-form">
                <label htmlFor="cpf">CPF: </label>
                <input type="text"
                id="cpf"
                name="cpf" onChange={handleChangeCadastro}/>
                </div>

                <div className="campo-form">
                <label htmlFor="dtNasc">Data de nascimento: </label>
                <input type="date"
                id="dtNasc"
                name="dtNasc" onChange={handleChangeCadastro}/>
                </div>
            
                <button type='submit'>Cadastrar</button>

            </form>
            </div>

            <div className="tabela">
                <TabelaCadastros obj={cadastroList} />
            </div>
        </>
    )
    
}

export default Vagas;