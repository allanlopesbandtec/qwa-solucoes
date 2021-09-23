import React, {useState} from 'react'
import axios from 'axios'
import TabelaCadastros from './tabela/TabelaCadastros';
 



function Cadastros() {

    const [cadastrosList, setCadastrosList] = useState([]);

    const [cadastro, setCadastro] = useState({});

    // const [numeroVagas, setNumeroVagas] = useState(0);

    

    const handleChangeCadastro= (event) => {
        const value = { ...cadastro }
        value[event.target.name] = event.target.value;
        setCadastro(value)
    };

    const handleSubmit = callback => event => {
       event.preventDefault();
       callback();
    };
    

  async function cadastrar(){    

        try {
         
            await axios.post(`http://localhost:8080/cadastros/1`, cadastro)
            .then((response) => {
                console.log(response)
                setCadastrosList(response.data);
                sessionStorage.setItem("respostaCadastro",response.data)
                alert("Cadastro efetuado com sucesso!")                
            })
        } catch (error) {
            console.log(error)
        }
    }
    
    // const handleChangeNumeroVagas = (event) => {
    //     const value = { ...numeroVagas }
    //     value[event.target.name] = event.target.value;
    //     setNumeroVagas(value.numeroVagas)
    // };

 

    console.log(cadastro)
    // console.log(numeroVagas)


    return (
        
        <>

        <div>
            <h1>Cadastros de usuários por vaga</h1>

            {/* {numeroVagas > 0 ? '' : 
            <label htmlFor="numeroVagas">Informe a quantidade de vagas:</label>  
            <input id="vanumeroVagas" name="numeroVagas" onChange={handleChangeNumeroVagas} />  */}

            <form onSubmit={handleSubmit}>
                
                <label htmlFor="nome">Nome:</label>
                <input id="nome" name="nome" onChange={handleChangeCadastro}  />

                <label htmlFor="sobrenome">Sobrenome:</label>
                <input id="sobrenome" name="sobrenome" onChange={handleChangeCadastro}  />

                <label htmlFor="cpf">Cpf:</label>
                <input id="cpf" name="cpf" onChange={handleChangeCadastro}  />

                <label htmlFor="dtNasc">Data de nascimento:</label>
                <input type='date' id="dtNasc" name="dtNasc" onChange={handleChangeCadastro}  />  

                <button onClick={cadastrar}>Cadastrar</button>
            </form>

            <TabelaCadastros obj={cadastrosList}/>

        </div>
        </>
    )

}

export default Cadastros;