import React, {useState} from 'react'
import axios from 'axios'
import TabelaCadastros from './tabela/TabelaCadastros';

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
    

    return (
        <>

        {cadastroList.length > 0 ?
        <>    
        </> 
        : 
        <>     
        <label htmlFor="numeroVagas">Número de vagas: </label>
        <input type="text"
        id="numeroVagas"
        name="numeroVagas" onChange={handleChangeVagas}/> 
        </>
        }
        

        <div>
             <h1>Cadastros de usuários por vaga</h1>
            
            <form onSubmit={handleSubmit}>

                <label htmlFor="nome">Nome: </label>
                <input type="text"
                id="nome"
                name="nome" onChange={handleChangeCadastro}/>

                <label htmlFor="sobrenome">Sobrenome: </label>
                <input type="text"
                id="sobrenome"
                name="sobrenome" onChange={handleChangeCadastro}/>

                <label htmlFor="cpf">Cpf: </label>
                <input type="text"
                id="cpf"
                name="cpf" onChange={handleChangeCadastro}/>
            
                <label htmlFor="dtNasc">Data de nascimento: </label>
                <input type="date"
                id="dtNasc"
                name="dtNasc" onChange={handleChangeCadastro}/>
            
                <button type='submit'>Cadastrar</button>

            </form>

        </div>

            <TabelaCadastros obj={cadastroList} />

        </>
    )
    
}

export default Vagas;