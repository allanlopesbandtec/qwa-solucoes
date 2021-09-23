import React, {useState} from 'react'
import axios from 'axios'
import TabelaCadastros from './tabela/TabelaCadastros';

function Vagas(){


    const [cadastroList, setCadastroList] = useState([]);

    //const [numeroVagas, setNumeroVagas] = useState(0);

    const [cadastro, setCadastro] = useState({});

    const handleSubmit = callback => event => {
       event.preventDefault();
       callback();
    };

    const handleChangeCadastro = (event) => {
        const value = { ...cadastro }
        value[event.target.name] = event.target.value;
        setCadastro(value)
    };

    async function cadastrar() {
        try {
            await axios.post(`https://localhost:8080/cadastros/1`, cadastro)
            .then((resposta) => {

                if(resposta.status === 201){
                    alert("Cadastrado com sucesso!")
                }

                console.log(resposta.data)
                setCadastroList(resposta.data)
            })
        } catch (error) {
            console.log(error)
        }

    }
    

    return (
        <>

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
            

                <button onClick={cadastrar}>Cadastrar</button>

            </form>


            <TabelaCadastros obj={cadastroList} />

        </div>

        </>
    )
    
}

export default Vagas;